/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Daos.GameDao;
import Daos.HavesDao;
import Daos.WantsDao;
import Dtos.Game;
import Dtos.Haves;
import Dtos.Wants;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Arc
 */
public class ViewGameCommand implements CommandInterface {

    /**
     * This command is used to view a single game it also shows what users want that game
     * what users have that game you have selected
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to singleGame.jsp.
     */
    public String execute(HttpServletRequest request, HttpServletResponse response){
        
        String id = request.getParameter("gameId");
        int gameId = Integer.parseInt(id);
        
        String forwardToJsp = "singleGame.jsp";
        String message = "No problems.";
        GameDao gameDao = new GameDao();
        HavesDao havesDao = new HavesDao();
        WantsDao wantsDao = new WantsDao();
        HttpSession session = request.getSession();
        try {
            Game retGame = gameDao.getGameById(gameId);
            List<Haves> usersWhoHave = havesDao.viewAllByGameId(gameId);
            List<Wants> usersWhoWant = wantsDao.viewAllByGameId(gameId);
            
            if (retGame != null) {
                session.setAttribute("singleGame", retGame);
                //session.removeAttribute("gameId");
                session.setAttribute("usersWhoHave", usersWhoHave);
                session.setAttribute("usersWhoWant", usersWhoWant);
            }else {
                message = "Game get failed..";
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        session.setAttribute("singleMessage", message);
        return forwardToJsp; 
    }
}
