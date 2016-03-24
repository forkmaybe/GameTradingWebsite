/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Command;

import Daos.GameDao;
import Daos.HavesDao;
import Dtos.Haves;
import Dtos.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author D00134372
 */
public class AddHaveCommand implements CommandInterface
{

    /**
     * This command is used to add a new Have to the loggedIn user's account.
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to have.jsp, the barterServlet uses the have command again to update session variables.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "BarterServlet?action=haves";
        HttpSession session = request.getSession();
        HavesDao haveDao = new HavesDao();
        GameDao gameDao = new GameDao();
        //Get session attributes.
        Integer GameId = (Integer) session.getAttribute("searchGameId");
        User loggedIn = (User) session.getAttribute("loggedUser");
        
        int UserId = loggedIn.getUserId();
        double SellingPrice = gameDao.getGameById(GameId).getPrice();
        
        try{//Add have.
            haveDao.addHave(UserId, GameId, SellingPrice);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        //Set sessions.
        String sessionId = session.getId();
        session.setAttribute("clientLoggedInId", sessionId);
        session.setAttribute("loggedUser", loggedIn); 
        
        List<Haves> havesList = haveDao.viewAllByUserId(loggedIn.getUserId());
        session.setAttribute("haveList",havesList);       
    
        return forwardToJsp;
    }
}
