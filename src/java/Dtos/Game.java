/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Arc
 */
public class Game implements Comparable<Game>, Serializable {

    private int gameId;
    private String title;
    private String platform;
    private String genre;
    private double quality;
    private double price;
    private String gameImage;
    //protected String description;//TODO For additional details????

    /**
     * Default constructor for Game, was used for tests.
     */
    public Game() {
        this.title = "Baldur's Gate";
        this.price = 19.99;
        this.platform = "PC";
        this.genre = "Role playing game";
        this.quality = 4.5;
        this.gameImage = "";
    }

    /**
     * @param title New Games title.
     * @param platform New Games platform.
     * @param genre New Games genre.
     * @param quality New Games quality.
     * @param price New Games price.
     * @param gameImage New Games gameImage.
     */
    public Game(String title, String platform, String genre, double quality, double price, String gameImage) {
        this.title = title;
        this.price = price;
        this.platform = platform;
        this.genre = genre;
        this.quality = quality;
        this.gameImage = gameImage;
    }

    /**
     * Constructor for
     *
     * @param gameId the id of the game
     * @param title the title of the game
     * @param platform what platform of the game
     * @param genre the type of the game
     * @param quality the quality of the game
     * @param price the price of the game
     * @param gameImage the image of the game
     */
    public Game(int gameId, String title, String platform, String genre, double quality, double price, String gameImage) {
        this.gameId = gameId;
        this.title = title;
        this.price = price;
        this.platform = platform;
        this.genre = genre;
        this.quality = quality;
        this.gameImage = gameImage;
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
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getPlatform() {
        return platform;
    }

    /**
     *
     * @param platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     *
     * @return
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     *
     * @return
     */
    public double getQuality() {
        return quality;
    }

    /**
     *
     * @param quality
     */
    public void setQuality(double quality) {
        this.quality = quality;
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
    public String getGameImage() {
        return gameImage;
    }

    /**
     *
     * @param gameImage
     */
    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    /**
     * takes a number and the variable and Encrpyts it by the the hashcode
     * method
     *
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.gameId;
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.platform);
        hash = 97 * hash + Objects.hashCode(this.genre);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.quality) ^ (Double.doubleToLongBits(this.quality) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.gameImage);
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
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        if (Double.doubleToLongBits(this.quality) != Double.doubleToLongBits(other.quality)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.gameImage, other.gameImage)) {
            return false;
        }
        return true;
    }

    /**
     *Prints out what ever is passed into it as a string
     *
     * @return your variable that were put inside it  
     */
    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", title=" + title + ", platform=" + platform + ", genre=" + genre + ", quality=" + quality + ", price=" + price + ", gameImage=" + gameImage + '}';
    }

    /**
     * compares two objects
     *
     * @param o is passed in to find if its the same
     */
    @Override
    public int compareTo(Game o) {
        if (platform.compareTo(o.platform) < 0) {
            return -1;
        }
        if (platform.compareTo(o.platform) > 0) {
            return 1;
        }
        if (title.compareTo(o.title) < 0) {
            return -1;
        }
        if (title.compareTo(o.title) > 0) {
            return 1;
        }

        return 0;
    }
}
