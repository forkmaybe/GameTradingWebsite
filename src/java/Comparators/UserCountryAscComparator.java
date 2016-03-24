/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;


import Dtos.User;
import java.util.Comparator;

/**
 *user by country then username
 * @author d00133633
 */
public class UserCountryAscComparator implements Comparator<User> {

    
    @Override
    public int compare(User o1, User o2) {
        if (o1.getCountry().compareTo(o2.getCountry()) < 0) {
            return -1;
        }
        if (o1.getCountry().compareTo(o2.getCountry()) > 0) {
            return 1;
        }
        if (o1.getUsername().compareTo(o2.getUsername()) < 0) {
            return -1;
        }
        if (o1.getUsername().compareTo(o2.getUsername()) > 0) {
            return 1;
        }
        return 0;
    }
}
