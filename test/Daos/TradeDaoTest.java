/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Trade;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiernan
 */
public class TradeDaoTest {
    
    public TradeDaoTest() {
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
     * Test of addTrade method, of class TradeDao.
     */
    @Test
    public void testAddTradeSuccess() {
        System.out.println("addTradeSuccess");
        Trade newTrade = new Trade(1,2,1,15.00);
        TradeDao instance = new TradeDao();
        instance.addTrade(newTrade);
        
    }
    @Test
    public void testAddTradeFail() {
        System.out.println("addTradeFail");
        TradeDao instance = new TradeDao();
        instance.addTrade(null);
    }
    /**
     * Test of viewAllTrades method, of class TradeDao.
     */
    @Test
    public void testViewAllTradesSuccess() {
        System.out.println("viewAllTradesSuccess");
        TradeDao instance = new TradeDao();
        List<Trade> expResult = instance.viewAllTrades();
        List<Trade> result = instance.viewAllTrades();
        assertEquals(expResult, result);
    }
    @Test
    public void testViewAllTradesFail() {
        System.out.println("viewAllTradesFail");
        TradeDao instance = new TradeDao();
        List<Trade> expResult = null;
        List<Trade> result = instance.viewAllTrades();
        assertEquals(expResult, result);
    }
    /**
     * Test of viewTradeById method, of class TradeDao.
     */
    @Test
    public void testViewTradeByIdSuccess() {
        System.out.println("viewTradeByIdSuccess");
        int compTradeId = 1;
        TradeDao instance = new TradeDao();
        Trade expResult = new Trade(1,2,3,1,15.00,true);
        Trade result = instance.viewTradeById(compTradeId);
        assertEquals(expResult, result);
    }
    @Test
    public void testViewTradeByIdWrongId() {
        System.out.println("testViewTradeByIdWrongId");
        int compTradeId = 2;
        TradeDao instance = new TradeDao();
        Trade expResult = new Trade(1,2,3,1,15.00,true);
        Trade result = instance.viewTradeById(compTradeId);
        assertEquals(expResult, result);
    }
    @Test
    public void testViewTradeByIdNotExsist() {
        System.out.println("testViewTradeByIdNotExsist");
        int compTradeId = 100;
        TradeDao instance = new TradeDao();
        Trade expResult = new Trade(1,2,3,1,15.00,true);
        Trade result = instance.viewTradeById(compTradeId);
        assertEquals(expResult, result);
    }
    /**
     * Test of completeTrade method, of class TradeDao.
     */
    @Test
    public void testCompleteTradeSuccess() {
        System.out.println("testCompleteTradeSuccess");
        Trade compTrade = new Trade(1,2,3,1,15.00,true);
        TradeDao instance = new TradeDao();
        instance.completeTrade(compTrade); 
    }
    @Test
    public void testCompleteTradeFail() {
        System.out.println("testCompleteTradeFail");
        Trade compTrade = null;
        TradeDao instance = new TradeDao();
        instance.completeTrade(compTrade); 
    }
}
