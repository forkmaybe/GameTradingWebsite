/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Daos;

import Dtos.Wants;
import Exception.DaoException;
import java.util.List;

/**
 *
 * @author d00135791
 */
public interface WantsDaoInterface {

    /**
     * gets all the wants for all users in the database 
     * @return returns all the users wants
     */
    public List<Wants> viewAll();

    /**
     * views all wants of a certain user
     * @param id gets the user by their ID
     * @return returns the want of the specified user
     */
    public List<Wants> viewAllByUserId(int id);

    /**
     * Adds a users want to the database.
     * @param UserId checks the ID of the logged in user and adds the game to their want list.
     * @param GameId checks the ID of the game and adds its details to the users want list.
     * @param MaxPrice sets the max price of the game.
     */
    
    /**
     * gets all wants where a user wants a certain game
     * @param id gets the game by its ID
     * @return returns the list of wants that contain that game
     */
    public List<Wants> viewAllByGameId(int id);
    
    public void addWants(int UserId, int GameId, double MaxPrice);

    /**
     * removes the specified want from the users want list.
     * @param WantId gets the ID of the game and deletes all its info from users want list.
     * @throws DaoException 
     */
    public void removeWant(int WantId) throws DaoException;
    
    /**
     * returns a certain want based on its ID
     * @param id gets the want from its ID
     * @return returns the specified want
     */
    public Wants viewByWantId(int id);
}
