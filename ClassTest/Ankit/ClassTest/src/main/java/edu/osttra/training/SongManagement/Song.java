package edu.osttra.training.SongManagement;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Song implements Serializable {
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

    public Song(){}

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

    static Song createSong(String line) throws ParseException {
        String args[] = line.split(",");
//        Date date = new Date();
//        String time = args[2];
//        System.out.println(date+"\n"+time);

        Song song = new Song(args[0],args[1], new SimpleDateFormat("mm.ss").parse(args[2]), Double.parseDouble(args[3]));

        return song;
    }

    @Override
    public String toString() {
        SimpleDateFormat f = new SimpleDateFormat("mm:ss");
        return String.format("%-20s %-10s %-12s %-12s\n", title, genre, f.format(duration), rating);
    }
}
