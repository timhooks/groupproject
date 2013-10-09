
package com.titanmusicplayer.bll;

import java.io.*;
import java.util.*;
import javazoom.jl.player.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MP3Player {
    
    private String filename;
    private Player player;
    
    
    public MP3Player() {

    }
    
    public void play(Song song) {
        try {
            FileInputStream fis     = new FileInputStream(song.getFilePath());
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + song.getFilePath());
            System.out.println(e);
        }

        new Thread() {
            @Override
            public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
    }
    
    public void stop() {
       if (this.player != null) {
           this.player.close();
       }
       
    }


      
    
}

    
