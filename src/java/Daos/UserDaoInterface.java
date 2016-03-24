/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.User;
import Exception.DaoException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Arc
 */
public interface UserDaoInterface {

    /**
     *Interface for login
     * @param inUsername
     * @param inPassword
     * @return
     */
    public User login(String inUsername, String inPassword);

    /**
     *Interface for findUserByUsername
     * @param uname
     * @return
     */
    public User findUserByUsername(String uname);

    /**
     *Interface for findUserById
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     *Interface for register
     * @param u
     * @return
     */
    public boolean register(User u);

    /**
     *Interface for editDetails
     * @param userid
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     * @param address
     * @param city
     * @param country
     * @return
     */
    public User editDetails(int userid, String username, String password, String firstName, String lastName, String address, String city, String country);

    /**
     *Interface for depositMoney
     * @param Balance
     * @param Username
     * @throws DaoException
     */
    public void depositMoney(double Balance, String Username)throws DaoException;

    /**
     *Interface for subtractMoney
     * @param Balance
     * @param Username
     * @throws DaoException
     */
    public void subtractMoney(double Balance, String Username) throws DaoException;

    /**
     *Interface for payGameHub
     * @param balance
     * @param sender
     * @throws SQLException
     */
    public void payGameHub(double balance, String sender) throws SQLException;

    /**
     *Interface for payUser
     * @param balance
     * @param payee
     * @throws SQLException
     */
    public void payUser(double balance, String payee) throws SQLException;

    /**
     *Interface for viewAllUsers
     * @return
     */
    public List<User> viewAllUsers();

    /**
     *Interface for removeUser
     * @param id
     * @throws DaoException
     */
    public void removeUser(int id) throws DaoException;
    //public void storeLog(User u, String message) throws IOException;
}
