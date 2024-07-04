import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Song {
    private String title;
    private String genre;
    private Date duration;
    private double rating;

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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Song(String title, String genre, Date duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    public static Song createSong(String csv) throws ParseException {
        String[] values = csv.split(",");
        String title = values[0];
        String genre = values[1];
        Date duration = new SimpleDateFormat("HH:mm:ss").parse(values[2]);
        double rating = Double.parseDouble(values[3]);

        return new Song(title,genre,duration,rating);
    }

    @Override
    public String toString(){
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return "name - " + title + " genre - " + genre + " duration - " + df.format(duration) + " rating - " + rating;
    }
}
