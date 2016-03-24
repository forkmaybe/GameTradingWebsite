/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.WantsDao;
import Dtos.User;
import Dtos.Wants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arc
 */
public class UserWantsCommand implements CommandInterface {
    
    /**
     * this command is used to view all wants of a certain user
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to wants.jsp
     */
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String forwardToJsp = "wants.jsp";
        WantsDao wDao = new WantsDao();
        
        HttpSession session = request.getSession();
        User loggedIn = (User) session.getAttribute("loggedUser"); 
        List<Wants> wantsList = wDao.viewAllByUserId(loggedIn.getUserId());
        session.setAttribute("wantList",wantsList);
        return forwardToJsp;
    }
}
