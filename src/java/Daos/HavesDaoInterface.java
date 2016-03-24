/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Daos;

import Dtos.Haves;
import Exception.DaoException;
import java.util.List;

/**
 * 
 * @author D00134372
 */
public interface HavesDaoInterface {

    /**
     * Interface for viewAllHaves().
     * @return all List of Haves in database.
     */
    public List<Haves> viewAll();

    /**
     * Interface for viewAllByUserId.
     * @param id Search by id.
     * @return List of Haves with all haves for a user.
     */
    public List<Haves> viewAllByUserId(int id);

    /**
     * Interface for viewAllByGameId().
     * @param id Searches by gameId.
     * @return All haves by Game id.
     */
    public List<Haves> viewAllByGameId(int id);

    /**
     * Interface for addHave()
     * @param UserId UserId to add with the have.
     * @param GameId GameId of the game that you have.
     * @param SellingPrice Price of the game selling.
     */
    public void addHave(int UserId, int GameId, double SellingPrice);

    /**
     * Interface for removeHave();
     * @param HaveId gets the ID of the have
     * @throws DaoException
     */
    public void removeHave(int HaveId) throws DaoException;
    
    /**
     * returns a certain have based on its ID
     * @param id gets the have from its ID
     * @return returns the specified have
     */
    public Haves viewByHaveId(int id);
}
