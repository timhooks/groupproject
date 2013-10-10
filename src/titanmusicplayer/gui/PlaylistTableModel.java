/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanmusicplayer.gui;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import music.entity.Playlist;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author paws
 */
public class PlaylistTableModel extends AbstractTableModel
{
  private static final long serialVersionUID = 6105842825518764825L;
  private ArrayList<Playlist> PlaylistList;

  public PlaylistTableModel()
  {
    super();
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
    Session session = sf.openSession();
     
    Query q = session.createQuery("from playlist");
    PlaylistList = new ArrayList<Playlist>(	q.list());
	
	session.close();
	sf.close();
  }
  
  public int getNumberOfRows()
  {
    return PlaylistList.size();
  }
  
  public int getNumberOfColumns()
  {
    return 5;
  }
  
  public Object getValueAt(int rowIndex, int columnIndex)
    {
        Playlist playlist = PlaylistList.get(rowIndex);
        Object[] values=new Object[]{playlist.getId(),playlist.getName()};
        return values[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        String[] columnNames=new String[]{"ID","Name"};
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
