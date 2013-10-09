/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titanmusicplayer.bll;

import java.util.*;


public class PlayList {
    private List<Song> songs;
    private String name;
    
    public PlayList(String name) {
        songs = new ArrayList<Song>();
        this.name = name;
    }
    
    
}
