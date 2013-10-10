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
    
    public static music.entity.Useraccount getUser(int id){
       session = helper.getSessionFactory().openSession();
       Transaction tx = session.beginTransaction();
       music.entity.Useraccount user = new music.entity.Useraccount();
       user = (music.entity.Useraccount) session.get(music.entity.Useraccount.class, id);
       return user;
    }
}
