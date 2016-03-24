/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Game;
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
public class GameDao extends Dao implements GameDaoInterface {

        // takes in the source of database connections and pass to super
    /**
     *
     * @param myDataSource
     */
        public GameDao(DataSource myDataSource) {
        super(myDataSource);
    }
    /**
     *
     */
    public GameDao() {
        // blank for default use
        super();
    }
    //TODO -- Finished i think...
    /**
     *view all the games in the database
     * adds each game to the array list
     * calls stored procedure
     * @return list of all games or null
     */
        public List<Game> viewAllGames() {
        Connection con = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        List<Game> games = new ArrayList<Game>();
        Game add = null;
        try {
            con = getConnection();
            String query = "{call GetAllGames()}";
            cs = con.prepareCall(query);
            rs = cs.executeQuery();
            while (rs.next()) {
                int GameId = rs.getInt("GameId");
                String Title = rs.getString("Title");
                String Platform = rs.getString("Platform");
                String Genre = rs.getString("Genre");
                double Quality = rs.getDouble("Quality");
                double Price = rs.getDouble("Price");
                String GameImage = rs.getString("GameImage");
                add = new Game(GameId, Title, Platform, Genre, Quality, Price,GameImage);
                games.add(add);
            }
            return games;
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
        return games;//May be null here when returned.
    }

    /**
     *gets game by its id
     * @param id is passed in to find the game with that id
     * @return game with the id passed in or null if not found
     */
    public Game getGameById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Game g = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM Games WHERE GameId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int GameId = rs.getInt("GameId");
                String Title = rs.getString("Title");
                String Platform = rs.getString("Platform");
                String Genre = rs.getString("Genre");
                double Quality = rs.getDouble("Quality");
                double Price = rs.getDouble("Price");
                String GameImage = rs.getString("GameImage");
                g = new Game(GameId, Title, Platform, Genre, Quality, Price,GameImage);
            }
            return g;
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
        return g;
    }
    
    /**
     *get game by its title
     * @param title of the game 
     * @return game if found or null if no game with that title
     */
    public Game getGameByTitle(String title) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Game g = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM games WHERE Title LIKE ?;";
            ps = con.prepareStatement(query);
            ps.setString(1, title);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int GameId = rs.getInt("GameId");
                String Title = rs.getString("Title");
                String Platform = rs.getString("Platform");
                String Genre = rs.getString("Genre");
                double Quality = rs.getDouble("Quality");
                double Price = rs.getDouble("Price");
                String GameImage = rs.getString("GameImage");
                g = new Game(GameId, Title, Platform, Genre, Quality, Price,GameImage);
            }
            return g;
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
        return g;
    }
    
        // Find game with that title and platform

    /**
     *gets game by title
     * @param gTitle game title
     * @return game if found or null if no game with that title
     */
        public Game findGameByTitle(String gTitle) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Game g = null;
        try {
            con = this.getConnection();

            String query = "SELECT * FROM games WHERE title = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, gTitle);
            
            
            rs = ps.executeQuery();
            if (rs.next()) {
                String Title = rs.getString("Title");
                String Platform = rs.getString("Platform");
                String Genre = rs.getString("Genre");
                double Quality = rs.getDouble("Quality");
                double Price = rs.getDouble("Price");
                String GameImage = rs.getString("GameImage");
                g = new Game(Title, Platform, Genre, Quality, Price,GameImage);
            }
        } catch (SQLException e) {
            System.err.println("\tA problem occurred during the findGameByTitlePlatform method:");
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
                System.err.println("A problem occurred when closing down the findGameByTitlePlatform method:\n" + e.getMessage());
            }
        }
        return g;     // null if the game already there
    }
    
    /**
     *add a game if title is not taken
     * @param g game passed in to add
     * @return boolean false if a game with that title exists
     */
    public boolean addGame(Game g){//Admin only.
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (findGameByTitle(g.getTitle()) == null) {
        try {
            con = getConnection();
            String query = "INSERT INTO games(Title, Platform, Genre, Quality, Price) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, g.getTitle());
            ps.setString(2, g.getPlatform());
            ps.setString(3, g.getGenre());
            ps.setDouble(4, g.getQuality());
            ps.setDouble(5, g.getPrice());
            ps.execute();
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
        return true;
        } else {
            return false;//a game with that title for that platform already exists
        }
    }
    
    /**
     *remove a game by its id
     * @param id used to find the game by its id
     * @throws DaoException thrown when there is a problem with the dao
     */
    @Override
    public void removeGame(int id) throws DaoException{
        Connection con = null;
        PreparedStatement ps = null;
      
        try {
            con = this.getConnection();

            String query = "DELETE FROM Games WHERE GameId = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ps.execute();
        } 
        catch (SQLException e) 
        {
            throw new DaoException("removeGame " + e.getMessage());
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
                throw new DaoException("removeGame" + e.getMessage());
            }
        }
    }
}
