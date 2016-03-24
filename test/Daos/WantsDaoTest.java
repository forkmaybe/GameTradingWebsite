/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Daos;

import Dtos.Wants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author d00133633
 */
public class WantsDaoTest {
    
    public WantsDaoTest() {
    }
    


    /**
     * Test of viewAll method, of class WantsDao.
     */
    @Test
    public void testViewAll() {
        System.out.println("viewAll");
        WantsDao instance = new WantsDao();
        List<Wants> expResult = instance.viewAll();
        List<Wants> result = instance.viewAll();
        assertEquals(expResult, result);
    }

    /**
     * Test of viewAllByUserId method, of class WantsDao.
     */
    @Test
    public void testViewAllByUserId() {
        System.out.println("viewAllByUserId");
        int id = 3;
        WantsDao instance = new WantsDao();
        ArrayList<Wants> expResult = new ArrayList<Wants>();
        Wants w1 = new Wants(2,3,2,10.00);
        Wants w2 = new Wants(8,3,8,10.00);
        Wants w3 = new Wants(12,3,12,10.00);
        Wants w4 = new Wants(16,3,16,10.00);
        Wants w5 = new Wants(20,3,20,10.00);
        
        expResult.add(w1);
        expResult.add(w2);
        expResult.add(w3);
        expResult.add(w4);
        expResult.add(w5);
        List<Wants> result = instance.viewAllByUserId(id);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of viewAllByGameId method, of class WantsDao.
     */
    @Test
    public void testViewAllByGameId() {
        System.out.println("viewAllByGameId");
        int id = 2;
        WantsDao instance = new WantsDao();
        ArrayList<Wants> expResult = new ArrayList<Wants>();
        Wants w = new Wants(2,3,2,10.00);
        
        expResult.add(w);
        List<Wants> result = instance.viewAllByGameId(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of addWants method, of class WantsDao.
     */
    @Test
    public void testAddWants() {
        System.out.println("addWant");
        int UserId = 2;
        int GameId = 15;
        double MaxPrice = 10.00;
        WantsDao instance = new WantsDao();
        instance.addWants(UserId, GameId, MaxPrice);
    }

    /**
     * Test of removeWant method, of class WantsDao.
     */
    @Test
    public void testRemoveWant() throws Exception {
        System.out.println("removeWant");
        int id = 2;
        WantsDao instance = new WantsDao();
        instance.removeWant(id);
    }
    
}

