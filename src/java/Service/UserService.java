/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Daos.UserDao;
import Dtos.User;

/**
 *
 * @author d00133633
 */
public class UserService {

    /**
     *adding a user, variables are passed in to make a user object, user is passed into the dao method called register
     * a boolean is returned from dao, if true then that username is not already in the database
     * if false then the username is already in the database
     * helps break up the code for the register command
     * @param username is passed in from the command to create a user object
     * @param password is passed in from the command to create a user object
     * @param firstName is passed in from the command to create a user object
     * @param lastName is passed in from the command to create a user object
     * @param address is passed in from the command to create a user object
     * @param city is passed in from the command to create a user object
     * @param country is passed in from the command to create a user object
     * @return a user or null if the username is already in the database
     */
    public User userRegister(String username, String password, String firstName, String lastName, String address, String city, String country) {
        User u = null;
        boolean registered;
        UserDao userDao = new UserDao();
        u = new User(username, password, firstName, lastName, address, city, country);
        registered = userDao.register(u);
        if(registered){// if username is free then registered is true
            return u;
        }
        else{
            return null;// if username taken u is null
        }
    }

}
