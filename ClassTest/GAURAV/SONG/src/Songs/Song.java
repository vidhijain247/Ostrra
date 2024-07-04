package Songs;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Song implements Serializable {
    private String title;
    private String genre;
    private Date duration;
    private Double rating;
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public Song() {
    }

    public Song(String title, String genre, String durations, Double rating) throws ParseException {
        this.title = title;
        this.genre = genre;
        this.duration = dateFormat.parse(durations);
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Date getDuration() {
        return duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDuration(String durations) throws ParseException {
        this.duration = dateFormat.parse(durations);
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public static Song createSong(String line) throws ParseException {
        String[] parts = line.split(",");
        return new Song(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }

    @Override
    public String toString() {
        return "Song [title=" + title + ", genre=" + genre + ", duration=" + dateFormat.format(duration) + ", rating=" + rating + "]";
    }
}