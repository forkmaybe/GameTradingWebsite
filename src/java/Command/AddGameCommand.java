/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import Dtos.Game;
import Service.GameService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luke
 */
public class AddGameCommand implements CommandInterface {

    /**
     * This command adds a new game to the website and the Database.
     * 
     * @param request used to get session variables.
     * @param response used for such things as setting headers and body tags. HTML Elements.
     * @return String of the jsp to forward to adminAccount.jsp.
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        GameService gameService = new GameService();
        // If registration is successful then go to login
        String forwardToJsp = "adminAccount.jsp";
        HttpSession session = request.getSession();
        String message = null;
        //Parameters from addGame.jsp.
        String title = request.getParameter("title");
        String platform = request.getParameter("platform");
        String genre = request.getParameter("genre");
        double quality = Double.parseDouble(request.getParameter("quality"));
        double price = Double.parseDouble(request.getParameter("price"));
        String imageUrl = request.getParameter("Image");
        //Create new game.
        Game g = gameService.addGame(title, platform, genre, quality, price,imageUrl);
        // if username taken u is null
        if (g == null) {
            message = "Title taken.";
        }// if any required fields are null
        else if (g.getTitle() == null || g.getPlatform() == null || g.getGenre() == null || g.getQuality() <=0 || g.getPrice() <=0) {
            message = "Game Add failed.";
        }// if any required fields are blank
        else if (g.getTitle() == null || g.getPlatform() == null || g.getGenre() == null || g.getQuality() <=0 || g.getPrice() <=0) {
            message = "Please fill required fields.";
        }
        else if (g.getQuality() >5 || g.getPrice() >10000) {
            message = "Please enter a valid number.";
        }
        session.setAttribute("regMessage", message);
        return forwardToJsp;
    }
    
}
