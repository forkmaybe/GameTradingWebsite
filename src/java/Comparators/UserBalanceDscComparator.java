/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Comparators;

import Dtos.User;
import java.util.Comparator;

/**
 *user by highest balance then username
 * @author d00133633
 */
public class UserBalanceDscComparator implements Comparator<User>{
            
    @Override
    public int compare(User o1, User o2) {
        if(o1.getBalance() > o2.getBalance()){
            return -1;
        }
        if(o1.getBalance() < o2.getBalance()){
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
