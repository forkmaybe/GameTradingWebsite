/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.io.Serializable;

/**
 *
 * @author D00134372
 */
public class Haves implements Serializable {

    private int haveId;
    private int userId;
    private int gameId;
    private double sellingPrice;

    /**
     *
     * @param haveId ID of the have, this is auto incremented
     * @param userId the ID of the user that is logged in
     * @param gameId the ID of the game the user is looking for
     * @param sellingPrice the price the game is selling for
     */
    public Haves(int haveId, int userId, int gameId, double sellingPrice) {
        this.haveId = haveId;
        this.userId = userId;
        this.gameId = gameId;
        this.sellingPrice = sellingPrice;
    }

    /**
     * gets the haves ID
     *
     * @return haves ID
     */
    public int getHaveId() {
        return haveId;
    }

    /**
     * sets the haves ID
     *
     * @param haveId the new ID being set
     */
    public void setHaveId(int haveId) {
        this.haveId = haveId;
    }

    /**
     * gets the users ID
     *
     * @return the users ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * sets the users ID
     *
     * @param userId users new ID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * gets the games ID
     *
     * @return the games ID
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * sets a games new ID
     *
     * @param gameId the games new ID
     */
    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    /**
     * gets the games selling price
     *
     * @return the games selling price
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * sets a games selling price
     *
     * @param sellingPrice the games new selling price
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * takes a number and the variable and Encrpyts it by the the hashcode
     * method
     *
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.haveId;
        hash = 61 * hash + this.userId;
        hash = 61 * hash + this.gameId;
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.sellingPrice) ^ (Double.doubleToLongBits(this.sellingPrice) >>> 32));
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
        final Haves other = (Haves) obj;
        if (this.haveId != other.haveId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (Double.doubleToLongBits(this.sellingPrice) != Double.doubleToLongBits(other.sellingPrice)) {
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
        return "Haves{" + "haveId=" + haveId + ", userId=" + userId + ", gameId=" + gameId + ", sellingPrice=" + sellingPrice + '}';
    }

}
