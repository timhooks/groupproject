/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanmusicplayer.bll;

import java.util.*;
import musicPlayerDB.entity.SongId;

public class Song {
    
    private String songName;
    private String bandName;
    
    public Song(String name, String bandName){
        this.songName = name;
        this.bandName = bandName;
    }
    
    public String getSongName() {
        return songName;
    }
    
    public String getBandName() {
        return bandName;
    }
    
    @Override
    public String toString() {
        return getSongName() + " by " + getBandName();
    }

     public String getFilePath() {
        return null;
        
        
    }
    
    
}
