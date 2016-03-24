package Command;

import Daos.TradeDao;
import Daos.UserDao;
import Daos.WantsDao;
import Dtos.Game;
import Dtos.Trade;
import Dtos.User;
import Dtos.Wants;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SellGameCommand implements CommandInterface {

    /**
     * This command is used to sell a game it does it by
     * Getting User id you are selling to
     * Checks if user has enough for that game
     * money is then Exchanged
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to BarterServlet?action=trade.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "BarterServlet?action=trade";
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        WantsDao wantsDao = new WantsDao();
        TradeDao tradeDao = new TradeDao();
        
        User loggedUser = (User) session.getAttribute("loggedUser");
        Game game = (Game) session.getAttribute("singleGame");
        int gameId = game.getGameId();

        String id = request.getParameter("wantId");//This is null???
        int wantId = Integer.parseInt(id);
        Wants useWant = wantsDao.viewByWantId(wantId);

        try {
        //Get User id you are selling to.
            //Buyer would be logged in user of course.
            //Check if user has enough for that game? Checked on the jsp. Need to do serverside?    
            //Exchange money. Stored procedure? maybe....Use transactions anyway...
            userDao.payGameHub(useWant.getMaxPrice(), userDao.findUserById(useWant.getUserId()).getUsername());
            //Create Trade.
            Trade t = new Trade(loggedUser.getUserId(), useWant.getUserId(), gameId, useWant.getMaxPrice());
            //Add trade.
            tradeDao.addTrade(t);
            User updatedUser = userDao.findUserById(loggedUser.getUserId());
            session.setAttribute("loggedUser", updatedUser);
        } catch (SQLException ex) {
            Logger.getLogger(SellGameCommand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return forwardToJsp;
    }
}
