package testq1;

import java.util.Date;

public class Song {
    private String title;
    private String genre;
    private Date duration;
    private double rating;

    
    public Song(String title, String genre, Date duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    
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

    
    public static Song createSong(String line) {
        String[] details = line.split(",");
        String title = details[0];
        String genre = details[1];
        Date duration = new Date(Long.parseLong(details[2])); 
        double rating = Double.parseDouble(details[3]);
        return new Song(title, genre, duration, rating);
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10s %-12s %-12s", title, genre, duration.toString(), rating);
    }

}
