/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Wants;
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
public class WantsDao extends Dao implements WantsDaoInterface{
    
        // takes in the source of database connections and pass to super

    /**
     *
     * @param myDataSource
     */
        public WantsDao(DataSource myDataSource) {
        super(myDataSource);
    }

    /**
     *
     */
    public WantsDao() {
        // blank for default use
        super();
    }
    
    /**
     * gets all the wants for all users in the database 
     * @return returns all the users wants
     */
    public List<Wants> viewAll() {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Wants> wants = new ArrayList<Wants>();
        try {
            con = getConnection();
            String query = "{call GetAllWants()}";
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                int wantId = rs.getInt("WantId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double maxPrice = rs.getDouble("MaxPrice");
                Wants add = new Wants(wantId,userId,gameId,maxPrice);
                wants.add(add);
            }
            return wants;
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
        return wants;//May be null here when returned.
    }
    
    /**
     * views all wants of a certain user
     * @param id gets the user by their ID
     * @return returns the want of the specified user
     */
    public List<Wants> viewAllByUserId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Wants> wants = new ArrayList<Wants>();
        Wants add = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM wants WHERE UserId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int wantId = rs.getInt("WantId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double maxPrice = rs.getInt("MaxPrice");
                add = new Wants(wantId,userId,gameId,maxPrice);
                wants.add(add);
            }
            return wants;
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
        return wants;//May be null here when returned.
    }
    
    /**
     * gets all wants where a user wants a certain game
     * @param id gets the game by its ID
     * @return returns the list of wants that contain that game
     */
    public List<Wants> viewAllByGameId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Wants> wants = new ArrayList<Wants>();
        Wants add = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM wants WHERE GameId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int wantId = rs.getInt("WantId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double maxPrice = rs.getInt("MaxPrice");
                add = new Wants(wantId,userId,gameId,maxPrice);
                wants.add(add);
            }
            return wants;
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
        return wants;//May be null here when returned.
    }
    
    /**
     * returns a certain want based on its ID
     * @param id gets the want from its ID
     * @return returns the specified want
     */
    public Wants viewByWantId(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Wants> wants = new ArrayList<Wants>();
        Wants ret = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM Wants WHERE WantId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int wantId = rs.getInt("WantId");
                int userId = rs.getInt("UserId");
                int gameId = rs.getInt("GameId");
                double maxPrice = rs.getInt("MaxPrice");
                ret = new Wants(wantId,userId,gameId,maxPrice);
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
        return ret;//May be null here when returned.
    }
    
    /**
     * Adds a users want to the database.
     * @param UserId checks the ID of the logged in user and adds the game to their want list.
     * @param GameId checks the ID of the game and adds its details to the users want list.
     * @param MaxPrice sets the max price of the game.
     */
    public void addWants(int UserId, int GameId, double MaxPrice){//Admin only.this isint admin only?
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String query = "INSERT INTO wants(UserId, GameId, MaxPrice) " + "VALUES(?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, UserId);
            ps.setInt(2, GameId);
            ps.setDouble(3, MaxPrice);
            
            ps.execute();
            
        } catch (SQLException e) {
            e.getMessage();
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
    }
    
    /**
     * removes the specified want from the users want list.
     * @param WantId gets the ID of the game and deletes all its info from users want list.
     * @throws DaoException 
     */
    public void removeWant(int WantId) throws DaoException{
        Connection con = null;
        PreparedStatement ps = null;
      
        try {
            con = this.getConnection();
            String query = "DELETE FROM wants WHERE WantId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, WantId);
            ps.execute();
        } 
        catch (SQLException e){
            throw new DaoException("removeWant " + e.getMessage());
        } 
        finally{
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
            catch (SQLException e){
                throw new DaoException("removeWant" + e.getMessage());
            }
        }
    }
}
