/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanmusicplayer.bll;

import java.util.*;


public class Library {
    
   private List<Song> songs;
   private String name;
   List<Song> songList = new ArrayList<Song>();
    
    public Library(int capacity) {
       capacity = capacity;
    }
    
    public void addNewSong(Song song) {
        songs.add(song);
    }
    
    public void removeSong(Song song) {
       for (int i = songs.size(); --i >= 0;) {
           Song s = songs.get(i);
           if(song != null)
               songs.remove(i);
       }
    }
    
    public static void sortList(ArrayList songList) {
        Collections.sort(songList, new BandComparator());
        }
    }

    
            
      
    
    
    

