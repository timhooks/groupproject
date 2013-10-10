
package com.titanmusicplayer.bll;

import java.io.*;
import java.util.*;
import javazoom.jl.player.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.player.advanced.AdvancedPlayer;
import sun.rmi.runtime.Log;


public class MP3Player {
    
    private String filename;
    private Player player;
    private ArrayList<Song> songs;
    private Thread playerThread;
    
    
    public MP3Player() {
        songs = new ArrayList<Song>();
    }
    
    public void play(final Song song) {
        new Thread() {
            @Override
            public void run() {
        try {
            FileInputStream fis     = new FileInputStream(song.getFilePath());
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + song.getFilePath());
            System.out.println(e);
        }

                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
    }
    
    public void stop() {
       if (this.player != null) {
           this.playerThread.stop();
       }
       
    }
    
    public void pause() {
        this.playerThread.interrupt();
        this.playerThread.stop();
        this.playerThread = null;
    }
    
    public Song nextSong(int index) {
       if((index + 1) < songs.size() )
    {
      Log.e("send next song at position " + (index + 1 ) + " with id " + songs.get(index+1).toString() );
      return songs.get(index + 1);  
    }
    else
    {
      Log.e("This is the last song!");
      return null;
    } 
    }
    
    public Song previousSong(int index) {
        if((index - 1) < 0)
    {
      Log.e("NO previous");
      return null;
    }
    else
    {
      Log.e("send previous song at position " + (index - 1 ) + " with " + songs.get(index - 1).toString() );
      return songs.get(index - 1);
    }
    }


      
    
}

    
