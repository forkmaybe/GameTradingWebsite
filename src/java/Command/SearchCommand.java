/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.GameDao;
import Dtos.Game;
import Dtos.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ken
 */
public class SearchCommand implements CommandInterface {

    /**
     * this command is used to display the details of a game the loggedin user has searched for
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to searchForGame.jsp
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String forwardToJsp = "searchForGame.jsp";
        GameDao gameDao = new GameDao();
        HttpSession session = request.getSession();
        User loggedIn = (User) session.getAttribute("loggedUser");
        String title = request.getParameter("title");
        Game game = null;

        try {
            game = gameDao.getGameByTitle(title);
            session.setAttribute("game", game);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        String sessionId = session.getId();
        session.setAttribute("clientLoggedInId", sessionId);
        session.setAttribute("loggedUser", loggedIn);

        return forwardToJsp;
    }
}
