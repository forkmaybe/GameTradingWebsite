/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.GameDao;
import Dtos.Game;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arc
 */
public class ViewAllCommand implements CommandInterface {

    /**
     * This command is used to view all games in the gamelist
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to games.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response){
        
        String forwardToJsp = "games.jsp";
        String message = "Success!";
        GameDao gameDao = new GameDao();
        HttpSession session = request.getSession();
        List<Game> gameList;
        try {
            gameList = gameDao.viewAllGames();
            if (gameList != null) {
                session.setAttribute("gameList", gameList);
            } else {
                message = "Games not loaded.";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        session.setAttribute("allGameMessage", message);
        return forwardToJsp; 
    }
}
