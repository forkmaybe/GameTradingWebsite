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
public class User implements Comparable<User>, Serializable {

    private int userId;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String address;
    private String city;
    private String country;
    private double rating;
    private double balance;
    private int isAdmin;

    /**
     * Default constructor for users, was used for tests.
     */
    public User() {
        this.username = "Arc";
        this.password = "password";
        this.firstname = "Sean";
        this.address = "Dundalk";
        this.balance = 100.00; //maybe give new accounts 100 points/1 euro??
    }
    //Constructor for new users

    /**
     * Constructor for registering users.
     *
     * @param username New user's username.
     * @param password New user's password.
     * @param firstname New user's firstname.
     * @param lastname New user's lastname.
     * @param address New user's address.
     * @param city New user's city.
     * @param country New user's country.
     */
    public User(String username, String password, String firstname, String lastname, String address, String city, String country) {
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.rating = 0;
        this.balance = 0; //maybe give new accounts 100 points/1 euro??
        this.isAdmin = 0;
    }

    /**
     * Constructor for
     *
     * @param userId id of the the users 
     * @param username the username the the user
     * @param password the password of the user
     * @param balance the balance of the user
     * @param firstname the first name of the user
     * @param lastname the last name of the user
     * @param address the address of the user
     * @param city the city of the user
     * @param country the country the user
     * @param rating the rating of the user
     * @param isAdmin if the user is a admin or not
     */
    public User(int userId, String username, String password, double balance, String firstname, String lastname, String address, String city, String country, double rating, int isAdmin) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.country = country;
        this.rating = rating;
        this.balance = balance;
        this.isAdmin = isAdmin;
    }

    /**
     *
     * @return
     */
    public boolean isAdmin() {
        if (this.isAdmin == 1) {
            //Then is admin.
            return true;
        } else {//is 0 or error.
            return false;
        }
    }

    /**
     *
     * @return
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public double getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public int getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param isAdmin
     */
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     * takes a number and the variable and Encrpyts it by the the hashcode
     * method
     *
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.username);
        hash = 37 * hash + Objects.hashCode(this.password);
        hash = 37 * hash + Objects.hashCode(this.firstname);
        hash = 37 * hash + Objects.hashCode(this.lastname);
        hash = 37 * hash + Objects.hashCode(this.address);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.balance) ^ (Double.doubleToLongBits(this.balance) >>> 32));
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
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.firstname, other.firstname)) {
            return false;
        }
        if (!Objects.equals(this.lastname, other.lastname)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (Double.doubleToLongBits(this.balance) != Double.doubleToLongBits(other.balance)) {
            return false;
        }
        return true;
    }

    /**
     * compares two objects
     *
     * @param o is passed in to find if its the same
     */
    @Override
    public int compareTo(User o) {
        if (username.compareTo(o.username) < 0) {
            return -1;
        }
        if (username.compareTo(o.username) > 0) {
            return 1;
        }
        if (balance < o.getBalance()) {
            return -1;
        }
        if (balance > o.getBalance()) {
            return 1;
        }
        return 0;
    }

    /**
     * Prints out what ever is passed into it as a string
     *
     * @return your variable that were put inside it
     */
    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address + ", city=" + city + ", country=" + country + ", rating=" + rating + ", balance=" + balance + ", isAdmin=" + isAdmin + '}';
    }

}
