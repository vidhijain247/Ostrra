import java.util.Date;
public class Song{
    private String title;
    private String genre;
    private Date duration;
    private Double rating;

    public Song(String title, String genre, Date duration, Double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }
    public Date getDuration() {
        return duration;
    }
    public String getGenre() {
        return genre;
    }
    public Double getRating() {
        return rating;
    }

    public static Song createSong(String l){
        String[] songDis = l.split(",");
        String title = songDis[0].trim();
        String genre = songDis[1].trim();
        Date duration = new Date();
        Double rating = Double.parseDouble(songDis[3].trim());
        return new Song(title,genre,duration,rating);


    }
    
    

}