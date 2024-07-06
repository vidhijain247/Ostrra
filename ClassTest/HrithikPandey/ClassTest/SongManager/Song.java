
import java.util.Date;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Song implements Serializable {
    private String title;
    private String genre;
    private Date duration;
    private Double rating;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public Date getDuration() {
        return duration;
    }
    public void setDuration(Date duration) {
        this.duration = duration;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }
     
    public Song createSong(String line) throws ParseException
    {
        String[] s= line.split(",");
        this.title= s[0];
        this.genre=s[1];
        this.duration= new SimpleDateFormat("mm.ss").parse(s[2]);
        this.rating=Double.parseDouble(s[3]);
        return this;    
    }
    @Override
    public String toString() {
        SimpleDateFormat format=new SimpleDateFormat("mm:ss");
        return String.format("%-20s %-15s %-10s %-5s\n", title, genre, format.format(duration), rating);
    }
}
