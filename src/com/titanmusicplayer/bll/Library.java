/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanmusicplayer.bll;

import java.util.*;


public class Library {
    
   private ArrayList songs;
    
    public Library() {
       this.songs= new ArrayList<Song>();
    }
    
    public void addNewSong(Song song) {
        songs.add(song);
    }
    
    public void removeSong(Song song) {
       songs.remove(song);
       }
    public void sortTitle() {
        Collections.sort(songs, Song.Comparators.bySongName);
    }
    
    public void sortArtist() {
        Collections.sort(songs, Song.Comparators.byArtistName);
    }
 }

    
            
      
    
    
    

