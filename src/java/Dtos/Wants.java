package Dtos;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author d00133633
 */
public class Wants implements Serializable {

    private int wantId;
    private int userId;
    private int GameId;
    private double maxPrice;

    /**
     * New wants constructor.
     *
     * @param userId Id of user for new want.
     * @param GameId Id of game for new want.
     */
    public Wants(int userId, int GameId) {
        this.userId = userId;
        this.GameId = GameId;
    }

    /**
     * Constructor for creating Wants.
     *
     * @param wantId WantId from DB.
     * @param userId UserId from DB.
     * @param GameId GameId from DB.
     * @param maxPrice maxPrice from DB.
     */
    public Wants(int wantId, int userId, int GameId, double maxPrice) {
        this.wantId = wantId;
        this.userId = userId;
        this.GameId = GameId;
        this.maxPrice = maxPrice;
    }

    /**
     * Basic getter for WantId.
     *
     * @return WantId from Want Object.
     */
    public int getWantId() {
        return wantId;
    }

    /**
     * Basic setter for WantId.
     *
     * @param wantId Sets wantId in Want Object.
     */
    public void setWantId(int wantId) {
        this.wantId = wantId;
    }

    /**
     * Basic getter for UserId.
     *
     * @return userId from Want Object.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Basic setter for UserId.
     *
     * @param userId Sets UserId for Wants object.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Basic getter for GameId.
     *
     * @return gameId from Want Object.
     */
    public int getGameId() {
        return GameId;
    }

    /**
     * Basic setter for GameId.
     *
     * @param GameId Sets GameId for Want object.
     */
    public void setGameId(int GameId) {
        this.GameId = GameId;
    }

    /**
     * Basic getter for MaxPrice.
     *
     * @return maxPrice from Want Object.
     */
    public double getMaxPrice() {
        return maxPrice;
    }

    /**
     * Basic setter for MaxPrice.
     *
     * @param maxPrice Sets MaxPrice for Want object.
     */
    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * takes a number and the variable and Encrpyts it by the the hashcode
     * method
     *
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.wantId;
        hash = 97 * hash + this.userId;
        hash = 97 * hash + this.GameId;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.maxPrice) ^ (Double.doubleToLongBits(this.maxPrice) >>> 32));
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
        final Wants other = (Wants) obj;
        if (this.wantId != other.wantId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.GameId != other.GameId) {
            return false;
        }
        if (Double.doubleToLongBits(this.maxPrice) != Double.doubleToLongBits(other.maxPrice)) {
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
        return "Wants{" + "wantId=" + wantId + ", userId=" + userId + ", GameId=" + GameId + ", maxPrice=" + maxPrice + '}';
    }

}
