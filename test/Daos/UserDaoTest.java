/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.User;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luke
 */
public class UserDaoTest {

    public UserDaoTest() {
    }

    /**
     * Test of login method, of class UserDao.
     */
    @Test
    public void testLoginCorrect() {
        System.out.println("login");
        String inUsername = "lukegoss7";
        String inPassword = "lukegoss7";
        UserDao instance = new UserDao();
        User expResult = new User(3, "lukegoss7", "b6008eb0442d5ae5aa254c424536098f", 50.30, "Luke", "Goss", "123 Bakers Street", "Drogheda", "Louth", 5.0, 1);
        User result = instance.login(inUsername, inPassword);
        assertEquals("Failed Login", expResult, result);
    }

    @Test
    public void testLoginWrongPassword() {
        System.out.println("login");
        String inUsername = "lukegoss7";
        String inPassword = "wrong";
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.login(inUsername, inPassword);
        assertEquals("Failed Login", expResult, result);
    }

    @Test
    public void testLoginWrongUsername() {
        System.out.println("login");
        String inUsername = "wrong";
        String inPassword = "lukegoss7";
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.login(inUsername, inPassword);
        assertEquals("Failed Login", expResult, result);
    }

    @Test
    public void testLoginWrongPasswordUsername() {
        System.out.println("login");
        String inUsername = "wrong";
        String inPassword = "wrong";
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.login(inUsername, inPassword);
        assertEquals("Failed Login", expResult, result);
    }

    /**
     * -------------------------------------------------------------------------
     * Test of findUserByUsername method, of class UserDao.
     */
    @Test
    public void testFindUserByUsernameCorrect() {
        System.out.println("findUserByUsername");
        String uname = "lukegoss7";
        UserDao instance = new UserDao();
        User expResult = new User(3, "lukegoss7", "b7542fd1b209c1b414e1d175c425616fa36c9e686d71025a373f79396cd1e746", 50.30, "Luke", "Goss", "123 Bakers Street", "Drogheda", "Louth", 5.0, 1);
        User result = instance.findUserByUsername(uname);
        assertEquals(expResult, result);
        //System.out.println(expResult.toString());
        //System.out.println(result.toString());
    }

    @Test
    public void testFindUserByUsernameWrong() {
        System.out.println("findUserByUsername");
        String uname = "wrong";
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.findUserByUsername(uname);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindUserByUsernameNegative() {
        System.out.println("findUserByUsername");
        String uname = "-1";
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.findUserByUsername(uname);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindUserByUsernameSQLInjection() {
        System.out.println("findUserByUsername");
        String uname = "' or '1'='1";
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.findUserByUsername(uname);
        assertEquals(expResult, result);
    }

    /**
     * Test of findUserById method, of class UserDao.
     */
    @Test
    public void testFindUserByIdCorrect() {
        System.out.println("findUserById");
        int id = 3;
        UserDao instance = new UserDao();
        User expResult = new User(3, "lukegoss7", "b7542fd1b209c1b414e1d175c425616fa36c9e686d71025a373f79396cd1e746", 50.30, "Luke", "Goss", "123 Bakers Street", "Drogheda", "Louth", 5.0, 1);
        User result = instance.findUserById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindUserByIdWrong() {
        System.out.println("findUserById");
        int id = 1;
        UserDao instance = new UserDao();
        User expResult = new User(3, "lukegoss7", "b7542fd1b209c1b414e1d175c425616fa36c9e686d71025a373f79396cd1e746", 50.30, "Luke", "Goss", "123 Bakers Street", "Drogheda", "Louth", 5.0, 1);
        User result = instance.findUserById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindUserByIdNegative() {
        System.out.println("findUserById");
        int id = -3;
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.findUserById(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindUserByIdZero() {
        System.out.println("findUserById");
        int id = 0;
        UserDao instance = new UserDao();
        User expResult = null;
        User result = instance.findUserById(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of register method, of class UserDao.
     */
    @Test
    public void testRegisterCorrect() {
        System.out.println("register");
        User u = new User(3, "lukegoss7", "b7542fd1b209c1b414e1d175c425616fa36c9e686d71025a373f79396cd1e746", 50.30, "Luke", "Goss", "123 Bakers Street", "Drogheda", "Louth", 5.0, 1);
        UserDao instance = new UserDao();
        boolean expResult = false;
        boolean result = instance.register(u);
        assertEquals(expResult, result);
    }

  
}
