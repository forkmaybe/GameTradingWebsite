/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Haves;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luke
 */
public class HavesDaoTest {

    public HavesDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of viewAll method, of class HavesDao.
     */
    @Test
    public void testViewAllSuccess() {
        System.out.println("viewAll");
        HavesDao instance = new HavesDao();
        List<Haves> expResult = instance.viewAll();
        List<Haves> result = instance.viewAll();
        assertEquals(expResult, result);

    }

    @Test
    public void testViewAllFail() {
        System.out.println("viewAllFail");
        HavesDao instance = new HavesDao();
        List<Haves> expResult = null;
        List<Haves> result = instance.viewAll();
        assertEquals(expResult, result);

    }
    
    

    /**
     * Test of viewAllByUserId method, of class HavesDao.
     */
    @Test
    public void testViewAllByUserIdSuccess() {
        System.out.println("viewAllByUserId");
        int id = 1;
        HavesDao instance = new HavesDao();
        List<Haves> expResult = instance.viewAllByUserId(id);
        List<Haves> result = instance.viewAllByUserId(id);
        assertEquals(expResult, result);

    }

    @Test
    public void testViewAllByUserIdFail() {
        System.out.println("viewAllByUserIdFail");
        int id = 2;
        HavesDao instance = new HavesDao();
        List<Haves> expResult = instance.viewAllByUserId(1);
        List<Haves> result = instance.viewAllByUserId(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of viewAllByGameId method, of class HavesDao.
     */
    @Test
    public void testViewAllByGameIdSuccess() {
        System.out.println("viewAllByGameId");
        int id = 1;
        HavesDao instance = new HavesDao();
        List<Haves> expResult = instance.viewAllByGameId(id);
        List<Haves> result = instance.viewAllByGameId(id);
        assertEquals(expResult, result);

    }

    @Test
    public void testViewAllByGameIdFail() {
        System.out.println("viewAllByGameIdFail");
        int id = 2;
        HavesDao instance = new HavesDao();
        List<Haves> expResult = instance.viewAllByGameId(1);
        List<Haves> result = instance.viewAllByGameId(id);
        assertEquals(expResult, result);

    }

    /**
     * Test of addHave method, of class HavesDao.
     */
    @Test
    public void testAddHaveSuccess() {
        System.out.println("addHave");
        int UserId = 1;
        int GameId = 2;
        double SellingPrice = 4.20;
        HavesDao instance = new HavesDao();
        instance.addHave(UserId, GameId, SellingPrice);

    }

    @Test
    public void testAddHaveFail() {
        System.out.println("addHaveFail");
        int UserId = -1;
        int GameId = -2;
        double SellingPrice = -15.00;
        HavesDao instance = new HavesDao();
        instance.addHave(UserId, GameId, SellingPrice);

    }

    /**
     * Test of removeHave method, of class HavesDao.
     */
    @Test
    public void testRemoveHaveSuccess() throws Exception {
        System.out.println("removeHave");
        int id = 1;
        HavesDao instance = new HavesDao();
        instance.removeHave(id);

    }

    public void testRemoveHaveFail() throws Exception {
        System.out.println("removeHaveFail");
        int id = -1;
        HavesDao instance = new HavesDao();
        instance.removeHave(id);

    }

}
