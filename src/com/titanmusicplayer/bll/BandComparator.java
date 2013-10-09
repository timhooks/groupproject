/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanmusicplayer.bll;

import java.util.Comparator;

/**
 *
 * @author student
 */
public class BandComparator implements Comparator<Song>{
     @Override
            public int compare(Song p1, Song p2){
                int res = p1.getSongName().compareToIgnoreCase(p2.getBandName());
                        if (res != 0)
                            return res;
                        return p1.getSongName().compareToIgnoreCase(p2.getBandName());
            }
}
