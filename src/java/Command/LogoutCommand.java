
package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author d00135791
 */
public class LogoutCommand implements CommandInterface{

    /**
     * This command is used to Login out off your account
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to logOut.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();
        session.invalidate();
        String forwardToJsp = "logOut.jsp";
        return forwardToJsp;
    }
                
}