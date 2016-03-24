/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.HavesDao;
import Dtos.Haves;
import Dtos.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arc
 */
public class UserHavesCommand implements CommandInterface {
    
    /**
     * this command is used to view all haves of a certain user
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to haves.jsp
     */
    public String execute(HttpServletRequest request, HttpServletResponse response){
        String forwardToJsp = "haves.jsp";
        HavesDao hDao = new HavesDao();
        
        HttpSession session = request.getSession();
        User loggedIn = (User) session.getAttribute("loggedUser"); 
        List<Haves> havesList = hDao.viewAllByUserId(loggedIn.getUserId());
        session.setAttribute("haveList",havesList);
        return forwardToJsp;
    }
}
