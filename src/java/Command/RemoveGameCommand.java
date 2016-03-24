/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Command;

import Daos.GameDao;
import Daos.UserDao;
import Dtos.Game;
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
 * @author d00133633
 */
public class RemoveGameCommand implements CommandInterface {

    /**
     * This command is used to remove a game from the database
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return adminAccount.jsp
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String game = request.getParameter("removeGame");
        int gameId = Integer.parseInt(game);
        GameDao gameDao = new GameDao();
        try {
            gameDao.removeGame(gameId);
        } catch (DaoException ex) {
            Logger.getLogger(RemoveUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = request.getSession();
        UserDao userDao = new UserDao();
        List<User> userList = userDao.viewAllUsers();
        session.setAttribute("userList", userList);//get the lists after the remove
        List<Game> gameList = gameDao.viewAllGames();//so the removed doesnt show up after the refresh
        session.setAttribute("gameList", gameList);
        return "adminAccount.jsp";
    }

    //How to run command without refreshing page and using ajax?

}
