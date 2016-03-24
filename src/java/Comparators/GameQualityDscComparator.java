/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Dtos.Game;
import java.util.Comparator;

/**
 *game by highest quality then title
 * @author Luke
 */
public class GameQualityDscComparator implements Comparator<Game>{
            
    @Override
    public int compare(Game o1, Game o2) {
        if(o1.getQuality() > o2.getQuality()){
            return -1;
        }
        if(o1.getQuality() < o2.getQuality()){
            return 1;
        }
        if (o1.getTitle().compareTo(o2.getTitle()) < 0) {
            return -1;
        }
        if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
            return 1;
        }
        return 0;
    }
}
