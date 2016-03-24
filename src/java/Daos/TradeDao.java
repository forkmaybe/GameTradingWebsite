/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.Trade;
import Dtos.User;
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
public class TradeDao extends Dao implements TradeDaoInterface {

        // takes in the source of database connections and pass to super
    /**
     *
     * @param myDataSource set
     */
    public TradeDao(DataSource myDataSource) {
        super(myDataSource);
    }

    /**
     *
     */
    public TradeDao() {
        // blank for default use
        super();
    }

    /**
     * This method simply adds a parameterized trade to the trade table on the
     * Database. It gets the connection, prepares the statement and sets the
     * variables for the table.
     *
     * @param newTrade This is the new trade being added from the command.
     */
    public void addTrade(Trade newTrade) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String query = "INSERT INTO Trades(SenderId,ReceivingId,GameId,Price,Completed) VALUES (?,?,?,?,?)";//Dont input tradeId or iscomplete.
            ps = con.prepareStatement(query);
            ps.setInt(1, newTrade.getSenderId());
            ps.setInt(2, newTrade.getReceiverId());
            ps.setInt(3, newTrade.getGameId());
            ps.setDouble(4, newTrade.getPrice());
            ps.setBoolean(5, newTrade.isIsComplete());
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method simply returns all trades in the database. It is a select
     * method and accesses and gets all trades.
     *
     * @return List of Trades Returns all trades in the trades table.
     */
    public List<Trade> viewAllTrades() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Trade> trades = new ArrayList<Trade>();
        Trade add = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM Trades;";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int tradeId = rs.getInt("tradeId");
                int senderId = rs.getInt("senderId");
                int receiverId = rs.getInt("ReceivingId");
                int gameId = rs.getInt("gameId");
                double price = rs.getDouble("price");
                boolean isComp = rs.getBoolean("Completed");
                add = new Trade(tradeId, senderId, receiverId, gameId, price, isComp);
                trades.add(add);
            }
            return trades;
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
        return trades;//May be null here when returned.
    }

    /**
     * This method is the same as the above, viewAllTrades, method, except it
     * returns a single trade by a parameterized id.
     * @param compTradeId This parameter is the id you are searching for.
     * @return The searched for Id.
     */
    public Trade viewTradeById(int compTradeId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Trade ret = null;
        try {
            con = getConnection();
            String query = "SELECT * FROM Trades WHERE TradeId = ?;";
            ps = con.prepareStatement(query);
            ps.setInt(1, compTradeId);
            rs = ps.executeQuery();

            while (rs.next()) {
                int tradeId = rs.getInt("TradeId");
                int senderId = rs.getInt("SenderId");
                int receiverId = rs.getInt("ReceivingId");
                int gameId = rs.getInt("GameId");
                double price = rs.getDouble("Price");
                boolean isComp = rs.getBoolean("Completed");
                ret = new Trade(tradeId, senderId, receiverId, gameId, price, isComp);
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
     * This method is used with the CompleteTradeCommand and sets the trade as completed and pays the sender.
     * 
     * @param compTrade This parameter is for the tradeId to be completed.
     */
    public void completeTrade(Trade compTrade) {
        //Make trade.isComplete() = true
        //Move money from my account to their account
        Connection con = null;
        PreparedStatement ps = null;
        UserDao userDao = new UserDao();
        try {//GameHub is sending the money over to the user.
            User u = userDao.findUserById(compTrade.getSenderId());
            String sender = u.getUsername();
            userDao.payUser(compTrade.getPrice(), sender);
            //Mark trade complete.
            con = getConnection();
            String query = "UPDATE Trades SET Completed = ?";
            ps = con.prepareStatement(query);
            ps.setBoolean(1, true);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
