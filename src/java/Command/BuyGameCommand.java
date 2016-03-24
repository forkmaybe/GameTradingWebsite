package Command;

import Daos.HavesDao;
import Daos.TradeDao;
import Daos.UserDao;
import Dtos.Game;
import Dtos.Haves;
import Dtos.Trade;
import Dtos.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author d00135791
 */
public class BuyGameCommand implements CommandInterface {

    /**
     * This command is used to buy a game from a user in GameHub.
     * You temporarily pay GameHub until the trade is finished and the seller gets paid.
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to haves.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "BarterServlet?action=trade";
        //Get session and Daos.
        HttpSession session = request.getSession();
        TradeDao tradeDao = new TradeDao();
        UserDao userDao = new UserDao();
        HavesDao havesDao = new HavesDao();
        //Get session variables needed.
        User loggedUser = (User) session.getAttribute("loggedUser");
        Game game = (Game)session.getAttribute("singleGame");
        int gameId = game.getGameId();
        //Get needed parameter haveId.
        String id = request.getParameter("haveId");
        int haveId = Integer.parseInt(id);
        //Get needed have from database.
        Haves useHave = havesDao.viewByHaveId(haveId);

        try {//Temporarily pay GameHub until you receive your item, then GameHub pays the seller.
            userDao.payGameHub(useHave.getSellingPrice(), loggedUser.getUsername());
            //Make and add new trade.
            Trade t = new Trade(useHave.getUserId(), loggedUser.getUserId(), gameId, useHave.getSellingPrice());
            tradeDao.addTrade(t);
            //Set updated user.
            User updatedUser = userDao.findUserById(loggedUser.getUserId());
            session.setAttribute("loggedUser", updatedUser);
        } catch (SQLException ex) {
            Logger.getLogger(BuyGameCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return forwardToJsp;
    }
}
