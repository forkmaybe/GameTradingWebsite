/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;


import Daos.WantsDao;
import Dtos.User;
import Dtos.Wants;
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
public class RemoveWantCommand implements CommandInterface {

    /**
     * This command is used to remove a want from the loggedIn user's account.
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to wants.jsp, the barterServlet uses the want command again to update session variables.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "wants.jsp";
        
        HttpSession session = request.getSession();
        User loggedIn = (User) session.getAttribute("loggedUser");
        String sessionId = session.getId();
        WantsDao wantsDao = new WantsDao();
        
        String id = request.getParameter("removeWant");
        int WantId = Integer.parseInt(id);
        
        try {
            wantsDao.removeWant(WantId);
        } catch (DaoException ex) {
            Logger.getLogger(RemoveUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        session.setAttribute("clientLoggedInId", sessionId);
        session.setAttribute("loggedUser", loggedIn);
        
        List<Wants> wantList = wantsDao.viewAllByUserId(loggedIn.getUserId());
        session.setAttribute("wantList", wantList);//get the lists after the remove
        
        return forwardToJsp;
    }

    //How to run command without refreshing page and using ajax?
}
