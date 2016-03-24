/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.io.Serializable;

/**
 *
 * @author Arc
 */
public class Trade implements Serializable {

    private int tradeId;
    private int senderId;
    private int receiverId;
    private int gameId;
    private double price;
    private boolean isComplete;

    //Constructor for new trade, which means isComplete will be false.
    /**
     *
     * @param senderId ID of the sender, the person that starts the trade
     * @param receiverId ID of the receiver, the person who gets the trade
     * @param gameId the ID of the game thats involved  
     * @param price the price the game
     */
    public Trade(int senderId, int receiverId, int gameId, double price) {
        //If created, isComplete will be false.
        this.senderId = senderId;//sender? or loggedin user anyway.
        this.receiverId = receiverId;//recipient??
        this.gameId = gameId;
        this.price = price;
        this.isComplete = false;
    }
    //Constructor for getting trades.

    /**
     *
     * @param tradeId the id of the trade 
     * @param senderId the id of the person who is starting the trade
     * @param receiverId the id of the person who is getting the trade
     * @param gameId the id of the game in the trade
     * @param price the price of the game in the trade
     * @param isComplete if the trade is complete or not 
     */
    public Trade(int tradeId, int senderId, int receiverId, int gameId, double price, boolean isComplete) {
        //If created, isComplete will be false.
        this.tradeId = tradeId;
        this.senderId = senderId;//sender? or loggedin user anyway.
        this.receiverId = receiverId;//recipient??
        this.gameId = gameId;
        this.price = price;
        this.isComplete = isComplete;
    }

    /**
     *
     * @return
     */
    public int getTradeId() {
        return tradeId;
    }

    /**
     *
     * @param tradeId
     */
    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    /**
     *
     * @return
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     *
     * @param senderId
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    /**
     *
     * @return
     */
    public int getReceiverId() {
        return receiverId;
    }

    /**
     *
     * @param receiverId
     */
    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    /**
     *
     * @return
     */
    public int getGameId() {
        return gameId;
    }

    /**
     *
     * @param gameId
     */
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public boolean isIsComplete() {
        return isComplete;
    }

    /**
     *
     * @param isComplete
     */
    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    /**
     * takes a number and the variable and Encrpyts it by the the hashcode
     * method
     *
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.tradeId;
        hash = 83 * hash + this.senderId;
        hash = 83 * hash + this.receiverId;
        hash = 83 * hash + this.gameId;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 83 * hash + (this.isComplete ? 1 : 0);
        return hash;
    }

    /**
     * find out if there the same
     *
     * @param obj is passed in to find out if the other object is equal to it it
     * will either return true or false depending if its the same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trade other = (Trade) obj;
        if (this.tradeId != other.tradeId) {
            return false;
        }
        if (this.senderId != other.senderId) {
            return false;
        }
        if (this.receiverId != other.receiverId) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (this.isComplete != other.isComplete) {
            return false;
        }
        return true;
    }

    /**
     * Prints out what ever is passed into it as a string
     *
     * @return your variable that were put inside it
     */
    @Override
    public String toString() {
        return "Trade{" + "tradeId=" + tradeId + ", senderId=" + senderId + ", receiverId=" + receiverId + ", gameId=" + gameId + ", price=" + price + ", isComplete=" + isComplete + '}';
    }

}
