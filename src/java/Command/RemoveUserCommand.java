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
 * @author Luke
 */
public class RemoveUserCommand implements CommandInterface {

    /**
     * This Command is used to remove a user from the website and database
     * after the user is removed it get the list after remove
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return to adminAccount.jsp.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String user = request.getParameter("removeUser");
        int userId = Integer.parseInt(user);
        UserDao userDao = new UserDao();
        try {
            userDao.removeUser(userId);
        } catch (DaoException ex) {
            Logger.getLogger(RemoveUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session = request.getSession();
        List<User> userList = userDao.viewAllUsers();
        session.setAttribute("userList", userList);//get the lists after the remove
        GameDao gameDao = new GameDao();        //so the removed doesnt show up after the refresh
        List<Game> gameList = gameDao.viewAllGames();
        session.setAttribute("gameList", gameList);
        return "adminAccount.jsp";
    }

    //How to run command without refreshing page and using ajax?
}
