/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Game;
import Exception.DaoException;
import java.util.List;

/**
 *
 * @author Arc
 */
public interface GameDaoInterface {

    /**
     * Interface for viewAllGames
     * @return
     */
    public List<Game> viewAllGames();

    /**
     * Interface for getGameById
     * @param id
     * @return
     */
    public Game getGameById(int id);

    /**
     *Interface for getGameByTitle
     * @param title
     * @return
     */
    public Game getGameByTitle(String title);

    /**
     *Interface for findGameByTitle
     * @param gTitle
     * @return
     */
    public Game findGameByTitle(String gTitle);

    /**
     *Interface for addGame
     * @param g
     * @return
     */
    public boolean addGame(Game g);

    /**
     *Interface for removeGame
     * @param id
     * @throws DaoException
     */
    public void removeGame(int id) throws DaoException;
}
