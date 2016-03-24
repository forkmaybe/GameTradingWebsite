/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.User;
import Exception.DaoException;
import SHA256.SHA;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.sql.DataSource;


/**
 *
 * @author Arc
 */
public class UserDao extends Dao implements UserDaoInterface {
    /**
     *  takes in the source of database connections for database pooling
     * @param  myDataSource
     */
    public UserDao(DataSource myDataSource) {
        super(myDataSource);
    }
    /**
     * blank for default use
     */
    public UserDao() {
        super();
    }
    /**
     *logs user in if the password and username match the ones in the database
     * 
     * @param inUsername passes in username from login form
     * @param inPassword passes in password un-encrypted from login form
     * @return User or null if the info is not found
     */
    public User login(String inUsername, String inPassword) {
        Connection con = null;
        PreparedStatement ps = null;
//        CallableStatement cs = null;
        ResultSet rs = null;
        User u = null;
        SHA hash = new SHA();
        try {
            con = this.getConnection();
            String query = "SELECT * from users WHERE Username = ? AND Password = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, inUsername);
            ps.setString(2, hash.encrypt(inPassword));
            rs = ps.executeQuery();

//            String query = "{GetUserByUsernamePassword(?, ?)}";
//            cs = con.prepareCall(query);
//            cs.setString(1, inUsername);
//            cs.setString(2, inPassword);
//            rs = cs.executeQuery();
            if (rs.next()) {//Then user is found.
                int UserId = rs.getInt("UserId");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                double balance = rs.getDouble("Balance");
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String country = rs.getString("Country");
                double rating = rs.getDouble("Rating");
                int isAdmin = rs.getInt("IsAdmin");
                u = new User(UserId, username, password, balance, firstname, lastname, address, city, country, rating, isAdmin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the login() method");
                e.getMessage();
            }
        }
        return u;//Can be null, hopefully is not.
    }
    // Find first user with that username

    /**
     *find the user by their username
     * used to check if username is taken
     * finds a user in the database where the username matches the one passed in
     * @param uname is passed in 
     * @return User or null if username is already taken
     */
        public User findUserByUsername(String uname) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM Users WHERE Username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, uname);

            rs = ps.executeQuery();
            if (rs.next()) {
                int UserId = rs.getInt("UserId");
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                double Balance = rs.getDouble("Balance");
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String Address = rs.getString("Address");
                String City = rs.getString("City");
                String Country = rs.getString("Country");
                double Rating = rs.getDouble("Rating");
                int isAdmin = rs.getInt("IsAdmin");
                u = new User(UserId, Username, Password, Balance, FirstName, LastName, Address, City, Country, Rating, isAdmin);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the findUserByUsername method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the findUserByUsername method:\n" + e.getMessage());
            }
        }
        return u;     // null if username taken
    }

    /**
     *find the user by their id
     * @param id is the users id passed in
     * @return User that matches the id passed in
     */
    public User findUserById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM users WHERE UserId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                int UserId = rs.getInt("UserId");
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                double Balance = rs.getDouble("Balance");
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String Address = rs.getString("Address");
                String City = rs.getString("City");
                String Country = rs.getString("Country");
                double Rating = rs.getDouble("Rating");
                int isAdmin = rs.getInt("IsAdmin");
                u = new User(UserId, Username, Password, Balance, FirstName, LastName, Address, City, Country, Rating, isAdmin);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the findUserByUsername method:");
            System.err.println("\t" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.err.println("A problem occurred when closing down the findUserById method:\n" + e.getMessage());
            }
        }
        return u;     // null if id taken
    }

    /**
     *adds a user to the database if the username is free then the user is added
     * password gets encrypted if username is not taken
     * @param u User trying to register
     * @return boolean true if username free, false if taken
     */
    public boolean register(User u) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SHA hash = new SHA();
        if (findUserByUsername(u.getUsername()) == null) {
            try {
                con = getConnection();

                String query1 = "INSERT INTO users (Username, Password, Balance, FirstName, LastName, Address, City, Country, Rating, IsAdmin) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                ps = con.prepareStatement(query1);
                ps.setString(1, u.getUsername());
                try {
                    ps.setString(2, hash.encrypt(u.getPassword()));
                } catch (Exception ex) {
                    System.out.println("exception with hashing password -- register");
                }
                ps.setDouble(3, u.getBalance());
                ps.setString(4, u.getFirstname());
                ps.setString(5, u.getLastname());
                ps.setString(6, u.getAddress());
                ps.setString(7, u.getCity());
                ps.setString(8, u.getCountry());
                ps.setDouble(9, u.getRating());
                ps.setInt(10, u.getIsAdmin());
                ps.execute();

            } catch (SQLException e) {
                System.out.println("Exception occured in the register() method");
                e.getMessage();
                e.printStackTrace();
            } finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        freeConnection(con);
                    }
                } catch (SQLException e) {
                    System.out.println("Exception occured in the finally section of the register() method");
                    e.getMessage();
                }
            }
            return true;
        } else {
            return false;//username taken
        }
    }
//EDITED THIS TO TEST COMMITS

    /**
     *edit your own users details
     * users variable passed in to update the variables of the user object
     * @param userid is passed in to find the user the in the database
     * @param username is passed in to update the old username with a new one
     * @param password encrypted, is passed in to update the old password with a new one
     * @param firstName is passed in to update the old first name with a new one
     * @param lastName is passed in to update the old last name with a new one
     * @param address is passed in to update the old username with a new one
     * @param city is passed in to update the old username with a new one
     * @param country is passed in to update the old username with a new one
     * @return user or null if invalid details entered
     */
    public User editDetails(int userid, String username, String password, String firstName, String lastName, String address, String city, String country) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        SHA hash = new SHA();
        try {
            con = getConnection();

            String query = "UPDATE users SET Username = ?, Password = ?, FirstName = ?, LastName = ?, Address = ?, City = ?, Country = ? WHERE UserId = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            try {
                ps.setString(2, hash.encrypt(password));
            } catch (Exception ex) {
                System.out.println("exception with hashing password -- edit details");
            }
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, address);
            ps.setString(6, city);
            ps.setString(7, country);
            ps.setInt(8, userid);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("SQL exception  -- edit details");
            e.getMessage();
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                System.out.println("Exception occured in the finally section of the editDetails() method");
                e.getMessage();
            }
        }
        return u;
    }

    /**
     *deposit money into your account
     * update the users balance byy adding it to the current balance
     * @param Balance passed in to add the amount to users balance
     * @param Username is passed in to tell which user to deposit to, username is unique
     * @throws DaoException is thrown when there is a problem with the dao
     */
    public void depositMoney(double Balance, String Username) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = this.getConnection();

            String query = "UPDATE Users SET Balance = Balance + ? WHERE Username = ?";
            ps = con.prepareStatement(query);
            ps.setDouble(1, Balance);
            ps.setString(2, Username);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("depositMoney() " + e.getMessage());
            }
        }
    }

    /**
     *withdraw money from your balance
     * updates the users balance by subtracting the amount from the current balance
     * @param Balance passed in to subtract the amount from users balance
     * @param Username is passed in to tell which user to deposit to, username is unique
     * @throws DaoException is thrown when there is a problem with the dao
     */
    public void subtractMoney(double Balance, String Username) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = this.getConnection();
            String query = "UPDATE Users SET Balance = Balance - ? WHERE Username = ?";
            ps = con.prepareStatement(query);
            ps.setDouble(1, Balance);
            ps.setString(2, Username);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("subtractMoney() " + e.getMessage());
            }
        }
    }

    /**
     *send payment to gamehub and store the sender so they can be payed when the game is received
     * uses transaction to rollback if there is an exception
     * @param balance passed in to add to gamehubs balance
     * @param sender passed in so they can be paid when the trade is complete
     * @throws SQLException is thrown when there is an sql problem 
     */
    public void payGameHub(double balance, String sender) throws SQLException {
        Connection con = null;
        PreparedStatement updateGameHub = null;
        PreparedStatement updateUser = null;
        String payGameHub = "UPDATE Users SET Balance = Balance + ? WHERE UserId = 1";
        String subSeller = "UPDATE Users SET Balance = Balance - ? WHERE UserName = ?";
        try {
            if (sender != null) {
                con = this.getConnection();
                con.setAutoCommit(false);
                updateGameHub = con.prepareStatement(payGameHub);
                updateUser = con.prepareStatement(subSeller);

                updateGameHub.setDouble(1, balance);
                updateGameHub.executeUpdate();

                updateUser.setDouble(1, balance);
                updateUser.setString(2, sender);
                updateUser.executeUpdate();
                con.commit();
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (updateGameHub != null) {
                    updateGameHub.close();
                }
                if (updateUser != null) {
                    updateUser.close();
                }
                con.setAutoCommit(true);
            } catch (SQLException e) {
                throw new DaoException("payUser() " + e.getMessage());
            }
        }
    }

    /**
     *pays the sender the cost of the game when the trade is confirmed by the receiver
     * takes the money out of gamehub's balance
     * transaction is used and rolled back if there is an exception
     * @param balance is the amount being paid to the sender
     * @param sender is the user being paid
     * @throws SQLException
     */
    public void payUser(double balance, String sender) throws SQLException {
        Connection con = null;
        PreparedStatement updateUser = null;
        PreparedStatement updateGameHub = null;
        
        String paySeller = "UPDATE Users SET Balance = Balance + ? Where UserName = ?";
        String subGameHub = "UPDATE Users SET Balance = Balance - ? Where UserId = 1";
        try {
            if (sender != null) {
                con = this.getConnection();
                con.setAutoCommit(false);

                updateUser = con.prepareStatement(paySeller);
                updateGameHub = con.prepareStatement(subGameHub);

                updateUser.setDouble(1, balance);
                updateUser.setString(2, sender);
                updateUser.executeUpdate();

                updateGameHub.setDouble(1, balance);
                updateGameHub.executeUpdate();
                con.commit();
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (updateGameHub != null) {
                    updateGameHub.close();
                }
                if (updateUser != null) {
                    updateUser.close();
                }
                con.setAutoCommit(true);
            } catch (SQLException e) {
                throw new DaoException("payUser() " + e.getMessage());
            }
        }
    }

    /**
     *view all the users
     * calls a stored procedure
     * @return a list of all the users
     */
    public List<User> viewAllUsers() {//returns list of all users
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        User add = null;
        try {
            con = getConnection();
            String query = "{call GetAllUsers()}";
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt("UserId");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                double balance = rs.getDouble("Balance");
                String firstName = rs.getString("Firstname");
                String lastName = rs.getString("LastName");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String country = rs.getString("Country");
                double rating = rs.getDouble("Rating");
                int isAdmin = rs.getInt("IsAdmin");
                add = new User(Id, username, password, balance, firstName, lastName, address, city, country, rating, isAdmin);
                users.add(add);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (cs != null) {
                    cs.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;//May be null here when returned.
    }

    /**
     *remove a user by their id
     * @param id is passed in to find the user to remove
     * @throws DaoException is thrown when there is a problem with the dao
     */
    public void removeUser(int id) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = this.getConnection();
            String query = "DELETE FROM Users WHERE UserId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.execute();
        } catch (SQLException e) {
            throw new DaoException("removeUser " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("removeUser" + e.getMessage());
            }
        }
    }

//    public void storeLog(User u, String message) throws IOException {
//        //This is to have a record of users and when they login/logout.
//        Writer writer = new BufferedWriter(new FileWriter("E:\\Course Work\\Year 3\\Semester 2\\Project\\gamehub-project\\log.txt"));
//        try {
//
//            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Calendar cal = Calendar.getInstance();
//            String date = dateFormat.format(cal.getTime());
//            if (u != null && date != null) {
//                String source = u.getUsername() + " ;" + message + " at " + date;
//                writer.write(source);
//                //finalize method??
//            } else {
//                writer.write("Error in storeLog " + date);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            writer.flush();
//            writer.close();
//        }
//    }

//    public void changeRating(User u,double calcedRating){
//        Connection con = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            con = this.getConnection();
//            double current = u.getRating();
//            
//            String query = "INSERT INTO users (USERID,RATINGSCORE) VALUES(?,?);";
//            ps = con.prepareStatement(query);
//            ps.setInt(1, u.getUserId());
//            ps.setDouble(2, calcedRating);
//            ps.executeUpdate();
//            
//            
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        
//    }
}
