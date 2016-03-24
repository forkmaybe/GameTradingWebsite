/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.HavesDao;
import Dtos.Haves;
import Dtos.User;
import Exception.DaoException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luke
 */
public class RemoveHaveCommand implements CommandInterface {

    /**
     * This command is used to remove a have from the loggedIn user's account.
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to haves.jsp, the barterServlet uses the have command again to update session variables.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp = "haves.jsp";
        
        HttpSession session = request.getSession();
        User loggedIn = (User) session.getAttribute("loggedUser");
        String sessionId = session.getId();
        
        String id = request.getParameter("removeHave");
        int HaveId = Integer.parseInt(id);
        HavesDao havesDao = new HavesDao();
        
        try {
            havesDao.removeHave(HaveId);
        } catch (DaoException ex) {
            Logger.getLogger(RemoveUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("clientLoggedInId", sessionId);
        session.setAttribute("loggedUser", loggedIn); 
        
        List<Haves> havesList = havesDao.viewAllByUserId(loggedIn.getUserId());
        session.setAttribute("haveList", havesList);//get the lists after the remove
        
        return forwardToJsp;
    }

    //How to run command without refreshing page and using ajax?
}
