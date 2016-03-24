
package Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface CommandInterface {
    
    /**
     * This is the interface for the CommandFactory and sets the abstract execute class.
     *
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return
     */
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
