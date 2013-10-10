/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package titanmusicplayer.gui;

import com.titanmusicplayer.bll.Song;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author paws
 */
public class SongTableModel extends AbstractTableModel
{
  private static final long serialVersionUID = 6105842825518764825L;
  private ArrayList<Song> songList;

  public SongTableModel()
  {
    super();
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
    Session session = sf.openSession();
     
    Query q = session.createQuery("from song");
    songList = new ArrayList<Song>(	q.list());
	
	session.close();
	sf.close();
  }
  
  public int getNumberOfRows()
  {
    return songList.size();
  }
  
  public int getNumberOfColumns()
  {
    return 5;
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
    {
        Song song = songList.get(rowIndex);
        Object[] values=new Object[]{song.getBandName(),song.getSongName()};
        return values[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        String[] columnNames=new String[]{"ID","Artist","Title"};
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
