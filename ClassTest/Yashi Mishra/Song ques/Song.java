package fourjuly;

import java.io.*;
import java.util.*;

class Song implements Serializable {
    private String title;
    private String genre;
    private String duration;
    private Double rating;

    public Song() {
    }

  
    public Song(String title, String genre, String duration, Double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
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

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

   
    public static Song createSong(String input) {
        String[] details = input.split(",");
        return new Song(details[0], details[1], details[2], Double.parseDouble(details[3]));
    }

    @Override
    public String toString() {
        return "Song [title=" + title + ", genre=" + genre + ", duration=" + duration + ", rating=" + rating + "]";
    }
}

class SongNotFoundException extends Exception {
    public SongNotFoundException(String message) {
        super(message);
    }
}
