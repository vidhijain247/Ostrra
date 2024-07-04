package Test;

import java.io.Serializable;

class Song implements Serializable {
    private String titles;
    private String generes;
    private String duration;
    private Double rating;

    public Song() {

    }

    public Song(String titles, String generes, String duration, Double rating) {
        this.titles = titles;
        this.generes = generes;
        this.duration = duration;
        this.rating = rating;
    }

    public String gettitles() {
        return titles;
    }

    public String getgeneres() {
        return generes;
    }

    public String getDuration() {
        return duration;
    }

    public Double getRating() {
        return rating;
    }

    public void settitles(String titles) {
        this.titles = titles;
    }

    public void setgeneres(String generes) {
        this.generes = generes;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public static Song makeSong(String line) {
        String[] details = line.split(",");
        return new Song(details[0], details[1], details[2], Double.parseDouble(details[3]));
    }

    @Override
    public String toString() {
        return "Song [titles=" + titles + ", generes=" + generes + ", duration=" + duration + ", rating=" + rating + "]";
    }
}
