/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Daos.GameDao;
import Dtos.Game;

/**
 *
 * @author Luke
 */
public class GameService {

    /**
     *adding a game, variables are passed in to make a game object, game is passed into the dao method called addGame
     * a boolean is returned from dao, if true then that game is not already in the database
     * if false then the game is already in the database
     * helps break up the code for the add game command
     * @param title is passed in from the command to create a game object
     * @param platform is passed in from the command to create a game object
     * @param genre is passed in from the command to create a game object
     * @param quality is passed in from the command to create a game object
     * @param price is passed in from the command to create a game object
     * @param imageUrl is passed in from the command to create a game object
     * @return a game or null if its already in the database
     */
    public Game addGame(String title, String platform, String genre, double quality, double price,String imageUrl) {
        Game g = null;
        boolean gameAdded;
        GameDao gameDao = new GameDao();
        g = new Game(title, platform, genre, quality, price,imageUrl);
        gameAdded = gameDao.addGame(g);
        if(gameAdded){// if game is not there then is true
            return g;
        }
        else{
            return null;// if game already there then g is null
        }
    }
}
