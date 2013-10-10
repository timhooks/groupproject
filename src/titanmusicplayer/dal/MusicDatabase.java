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
    
    public static void addSongToLibrary(String title, String artist, BigDecimal duration, String filepath){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Library library1 = new music.entity.Library();
        music.entity.Song song = new music.entity.Song();
        library1 = getLibrary(1);
        song.setTitle(title);
        song.setArtist(artist);
        song.setDuration(duration);
        song.setFilepath(filepath);
        song.setLibrary(library1);
        session.save(library1);
        session.save(song);
        tx.commit();
        session.close();
    }
    
     public static void addSongToPlaylist(int id){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Playlist playlist1 = new music.entity.Playlist();
        music.entity.Song song = new music.entity.Song();
        playlist1 = getPlaylist(1);
        song = (music.entity.Song) session.get(music.entity.Song.class, id);
        song.setPlaylist(playlist1);
        session.save(playlist1);
        session.save(song);
        tx.commit();
        session.close();
    }
     
     public static music.entity.Song getSong(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Song song = new music.entity.Song();
       song = (music.entity.Song) session.get(music.entity.Song.class, id);
       return song;
     }
     
    public static void addLibrary(){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Library library = new music.entity.Library();
        session.save(library);
        tx.commit();
        session.close();
    }
    
     public static music.entity.Library getLibrary(int id){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Library library = new music.entity.Library();
        library = (music.entity.Library) session.get(music.entity.Library.class, id);
        return library;
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
     
    public static music.entity.Playlist getPlaylist(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Playlist playlist = new music.entity.Playlist();
       playlist = (music.entity.Playlist) session.get(music.entity.Playlist.class, id);
       return playlist;
     }
}
