/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Daos;

import Dtos.Game;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author d00133633
 */
public class GameDaoTest {
    
    public GameDaoTest() {
    }

    
    @Test
    public void testGetGameById() {
        System.out.println("getGameById");
        int id = 0;
        GameDao instance = new GameDao();
        Game expResult = null;
        Game result = instance.getGameById(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of getGameByTitle method, of class GameDao.
     */
    @Test
    public void testGetGameByTitle() {
        System.out.println("getGameByTitle");
        String title = "";
        GameDao instance = new GameDao();
        Game expResult = null;
        Game result = instance.getGameByTitle(title);
        assertEquals(expResult, result);

    }

    /**
     * Test of findGameByTitle method, of class GameDao.
     */
    @Test
    public void testFindGameByTitle() {
        System.out.println("findGameByTitle");
        String gTitle = "";
        GameDao instance = new GameDao();
        Game expResult = null;
        Game result = instance.findGameByTitle(gTitle);
        assertEquals(expResult, result);

    }

    /**
     * Test of addGame method, of class GameDao.
     */
    @Test
    public void testAddGame() {
        System.out.println("addGame");
        Game g = null;
        GameDao instance = new GameDao();
        boolean expResult = false;
        boolean result = instance.addGame(g);
        assertEquals(expResult, result);

    }

    /**
     * Test of removeGame method, of class GameDao.
     */
    @Test
    public void testRemoveGame() throws Exception {
        System.out.println("removeGame");
        int id = 0;
        GameDao instance = new GameDao();
        instance.removeGame(id);

    }
    
}
