/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanmusicplayer.dal;

import music.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Tim
 */
public class UserDatabase {
    
    private static Session session;
    private static HibernateUtil helper;
    
    public static void addUser(String username, String password, String email){
        session = helper.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        music.entity.Useraccount account = new music.entity.Useraccount();
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);
        MusicDatabase.addLibrary();
        session.save(account);
        tx.commit();
        session.close();
    }
    
    public static String getUsername(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Useraccount user = new music.entity.Useraccount();
       user = (music.entity.Useraccount) session.get(music.entity.Useraccount.class, id);
       return user.getUsername(); 
    }
    
    public static String getPassword(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Useraccount user = new music.entity.Useraccount();
       user = (music.entity.Useraccount) session.get(music.entity.Useraccount.class, id);
       return user.getPassword(); 
    }
    
    public static String getEmail(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Useraccount user = new music.entity.Useraccount();
       user = (music.entity.Useraccount) session.get(music.entity.Useraccount.class, id);
       return user.getEmail(); 
    }
    
    public static music.entity.Useraccount getUser(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Useraccount user = new music.entity.Useraccount();
       user = (music.entity.Useraccount) session.get(music.entity.Useraccount.class, id);
       return user;
    }
}
