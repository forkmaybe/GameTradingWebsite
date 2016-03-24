/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Haves;
import Exception.DaoException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Arc
 */
public class HavesDao extends Dao implements HavesDaoInterface{

        // takes in the source of database connections and pass to super

    /**
     * used for database pooling
     * @param myDataSource
     */
        public HavesDao(DataSource myDataSource) {
        super(myDataSource);
    }

    /**
     * used for database pooling
     */
    public HavesDao() {
        // blank for default use
        super();
    }
    
    /**
     * gets all the haves for all users in the database 
     * @return all List of Haves in database.
     */
    public List<Haves> viewAll() {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Haves> haves = new ArrayList<Haves>();
        Haves add = null;
        try {
            con = getConnection();
            String query = "{call GetAllHaves()}";
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                int haveId = rs.getInt("haveId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double sellingPrice = rs.getDouble("SellingPrice");
                add = new Haves(haveId,userId,gameId,sellingPrice);
                haves.add(add);
            }
            return haves;
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
        return haves;
    }
    
    /**
     * views all haves of a certain user
     * @param id gets the user by their ID
     * @return List of Haves with all haves for a user.
     */
    public List<Haves> viewAllByUserId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Haves> haves = new ArrayList<Haves>();
        Haves add;
        try {
            con = getConnection();
            String query = "SELECT * FROM Haves WHERE UserId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int haveId = rs.getInt("HaveId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double sellingPrice = rs.getDouble("SellingPrice");
                add = new Haves(haveId,userId,gameId,sellingPrice);
                haves.add(add);
            }
            return haves;
        } catch (SQLException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
        return haves;
    }
    
    /**
     * gets all haves where a user has a certain game
     * @param id Searches by gameId.
     * @return All haves by Game id.
     */
    public List<Haves> viewAllByGameId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Haves> haves = new ArrayList<Haves>();
        Haves add;
        try {
            con = getConnection();
            String query = "SELECT * FROM haves WHERE gameId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int haveId = rs.getInt("HaveId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double sellingPrice = rs.getDouble("SellingPrice");
                add = new Haves(haveId,userId,gameId,sellingPrice);
                haves.add(add);
            }
            return haves;
        } catch (SQLException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
        return haves;
    }
    /**
     * returns a certain have based on its ID
     * @param id gets the have from its ID
     * @return returns the specified have
     */
    public Haves viewByHaveId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Haves ret = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM Haves WHERE HaveId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int haveId = rs.getInt("HaveId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double sellingPrice = rs.getDouble("SellingPrice");
                ret = new Haves(haveId,userId,gameId,sellingPrice);
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
        return ret;
    }
    
    /**
     * Adds a users have to the database.
     * @param UserId UserId to add with the have.
     * @param GameId GameId of the game that you have.
     * @param SellingPrice Price of the game selling.
     */
    public void addHave(int UserId, int GameId, double SellingPrice){
        Connection con = null;
        PreparedStatement ps = null;
        GameDao gameDao = new GameDao();

        try {
            con = getConnection();
            
            String query = "INSERT INTO haves(UserId, GameId, SellingPrice) " + "VALUES(?,?,?)";

            ps = con.prepareStatement(query);
            ps.setInt(1, UserId);
            ps.setInt(2, GameId);

            ps.setDouble(3, SellingPrice);
            
            ps.execute();
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
                e.printStackTrace();
            }
        }
    }
    
    /**
     * removes the specified have from the users haves list.
     * @param HaveId gets the ID of the have
     * @throws DaoException
     */
    public void removeHave(int HaveId) throws DaoException{
        Connection con = null;
        PreparedStatement ps = null;
      
        try {
            con = this.getConnection();

            String query = "DELETE * FROM Haves WHERE HaveId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, HaveId);

            ps.execute();
        } 
        catch (SQLException e) 
        {
            throw new DaoException("removeHave " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("removeHave" + e.getMessage());
            }
        }
    }
}
