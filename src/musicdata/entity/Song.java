package musicdata.entity;
// Generated Oct 3, 2013 4:36:56 PM by Hibernate Tools 3.2.1.GA



/**
 * Song generated by hbm2java
 */
public class Song  implements java.io.Serializable {


     private int id;
     private String artist;
     private String title;

    public Song() {
    }

	
    public Song(int id) {
        this.id = id;
    }
    public Song(int id, String artist, String title) {
       this.id = id;
       this.artist = artist;
       this.title = title;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getArtist() {
        return this.artist;
    }
    
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }




}


