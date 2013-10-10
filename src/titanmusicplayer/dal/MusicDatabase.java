/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * Testing again.
 */
package titanmusicplayer.dal;

import java.math.BigDecimal;
import music.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author Tim
 */
public class MusicDatabase {
    private static Session session;
    private static HibernateUtil helper;
    
    public static void addSong(String title, String artist, BigDecimal duration, String filepath){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Song song = new music.entity.Song();
        song.setTitle(title);
        song.setArtist(artist);
        song.setDuration(duration);
        song.setFilepath(filepath);
        session.save(song);
        tx.commit();
        session.close();
    }
    
    public static void addLibrary(){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Library library = new music.entity.Library();
        session.save(library);
        tx.commit();
        session.close();
    }
    
     public static void addPlaylist(String name){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Playlist playlist = new music.entity.Playlist();
        playlist.setName(name);
        session.save(playlist);
        tx.commit();
        session.close();
    }
     
     public static String getSong(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Song song = new music.entity.Song();
       song = (music.entity.Song) session.get(music.entity.Song.class, id);
       return song.getTitle();
     }
}
