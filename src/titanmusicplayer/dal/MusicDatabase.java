/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanmusicplayer.dal;

import musicDB.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author Tim
 */
public class MusicDatabase {
    private static Session session;
    private static HibernateUtil helper;
    
    public static void addSong(String filename, String title){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        musicdata.entity.Song song = new musicdata.entity.Song();
        song.setTitle(title);
        session.save(song);
        tx.commit();
        session.close();
    }
     
     public static String getSong(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       musicdata.entity.Song song = new musicdata.entity.Song();
       song = (musicdata.entity.Song) session.get(musicdata.entity.Song.class, id);
       return song.getTitle();
     }
}
