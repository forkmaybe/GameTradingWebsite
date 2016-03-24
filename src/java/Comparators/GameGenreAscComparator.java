/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comparators;

import Dtos.Game;
import java.util.Comparator;

/**
 *game by genre then title
 * @author Luke
 */
public class GameGenreAscComparator implements Comparator<Game>{
                
    @Override
    public int compare(Game o1, Game o2) {
        if (o1.getGenre().compareTo(o2.getGenre()) < 0) {
            return -1;
        }
        if (o1.getGenre().compareTo(o2.getGenre()) > 0) {
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
