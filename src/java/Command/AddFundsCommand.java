/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Command;

import Daos.UserDao;
import Dtos.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddFundsCommand implements CommandInterface
{
    /**
     * This command is used to add money to your userAccount.
     * It takes the value of a html inputbox and if valid adds the money.
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to userAccount.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "userAccount.jsp"; 
        String message;
        UserDao userDao = new UserDao();
        HttpSession session = request.getSession();
        
        double Balance = Double.valueOf(request.getParameter("amount"));
        User loggedIn = (User) session.getAttribute("loggedUser");
        String Username = loggedIn.getUsername();
        
        try{
            userDao.depositMoney(Balance, Username);
            loggedIn.setBalance(loggedIn.getBalance() + Balance);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        message = "Add funds complete.";
        session.setAttribute("fundsMessage", message);
        String sessionId = session.getId();
        session.setAttribute("clientLoggedInId", sessionId);
        session.setAttribute("loggedUser", loggedIn);        
    
        return forwardToJsp;
}
}

