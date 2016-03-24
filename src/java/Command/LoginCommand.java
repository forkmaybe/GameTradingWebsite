package Command;

import Daos.GameDao;
import Daos.UserDao;
import Dtos.Game;
import Dtos.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginCommand implements CommandInterface {

    /**
     * This command is for logging in to game hub, it checks if the user exists
     * if the supplied information is correct. It checks if the user is an admin
     * or not, and directs appropriately.
     *
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags,HTML Elements.
     * @return String of the jsp to forward to adminAccount.jsp or
     * userAccount.jsp. If login unsuccessful then return to login and show
     * message.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String forwardToJsp;
        UserDao userDao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String message = "Blank";
        HttpSession session = request.getSession();
        User user = null;
        //Checking if username and password are blank.
        if (username != null && password != null) {
            try {//Attempt to login to the site.
                user = userDao.login(username, password);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            //If null then user not found.
            if (user != null) {
                String sessionId = session.getId();
                session.setAttribute("clientLoggedInId", sessionId);
                session.setAttribute("loggedUser", user);
                //If user is an admin then display all users.
                if (user.getIsAdmin() == 1) {
                    List<User> userList = userDao.viewAllUsers();
                    session.setAttribute("userList", userList);
                    GameDao gameDao = new GameDao();
                    List<Game> gameList = gameDao.viewAllGames();
                    session.setAttribute("gameList", gameList);
                    forwardToJsp = "adminAccount.jsp";
                } else {
                    forwardToJsp = "userAccount.jsp";
                }
                //Logins failed.
            } else {
                message = "Login failure, incorrect information.";
                session.setAttribute("loginMessage", message);
                forwardToJsp = "login.jsp";
            }
            //Username or password = null.
        } else {
            message = "Login failure, please fill in required fields.";
            session.setAttribute("loginMessage", message);
            forwardToJsp = "login.jsp";
        }
        return forwardToJsp;
    }
}
