import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Song implements Serializable{
    private String title;
    private String genre;
    private Date duration;
    private double rating;
    public Song(){}
    public Song(String title, String genre, Date duration,Double rating)
    {
        this.title=title;
        this.genre=genre;
        this.duration=duration;
        this.rating=rating;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title= title;
    }
    public String getGenre()
    {
        return genre;
    }
    public void setGenre(String genre)
    {
        this.genre= genre;
    }
    public Date getDuration()
    {
        return duration;
    }
    public void setDuration(Date duration)
    {
        this.duration= duration;
    }
    public Double getRating()
    {
        return rating;
    }
    public void setRating(Double rating)
    {
        this.rating=rating;
    }
    public static Song createSong(String line)
    {
        String[] details=line.split(",");
        SimpleDateFormat s=new SimpleDateFormat("mm:ss");
        try {
            return new Song(details[0],details[1],s.parse(details[2]),Double.parseDouble(details[3]));
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    public String toString()
    {
        SimpleDateFormat s= new SimpleDateFormat("mm:ss");
        return String.format("%-20s %-10s %-12s %-12.1f", title, genre, s.format(duration), rating);
    }
}
