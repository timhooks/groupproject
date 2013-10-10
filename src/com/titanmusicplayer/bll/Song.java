/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanmusicplayer.bll;

import java.util.*;


public class Song implements Comparable<Song> {
    
    private static String songName;
    private static String artistName;
    private static String filePath;
    
    public Song(String songName, String bandName, String filePath){
        this.songName = songName;
        this.artistName = artistName;
        this.filePath = filePath;
    }
    
    public String getSongName() {
        return songName;
    }
    
    public String getBandName() {
        return artistName;
    }

    @Override
    public int compareTo(Song t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static class Comparators {
        public static Comparator<Song> bySongName = new Comparator<Song>() {
            @Override
            public int compare(Song t, Song t1) {
                return t.songName.compareTo(t1.songName);
            }
        };
        public static Comparator<Song> byArtistName = new Comparator<Song>() {
            @Override
            public int compare(Song t, Song t1) {
             return t.artistName.compareTo(t1.artistName);
            }
        };
    }

     public String getFilePath() {
        return this.filePath;
        
        
    }
    
    
}
