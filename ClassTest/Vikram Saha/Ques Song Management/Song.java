import java.io.Serializable;
import java.util.Date;

public class Song implements Serializable {
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
    @Override
    public String toString() {
        Date s=new Date();
        s.setTime(0);
        Long d=duration.getTime()-s.getTime();
        return String.format("%-20s %-15s %-10s %-5s\n", title, genre, d, rating);
    }
    public long getActualDuration(){
        Date s=new Date();
        s.setTime(0);
        Long d=duration.getTime()-s.getTime();
        return d;
    }
    public Song() {
    }
    public Song(String title, String genre, Date duration, double rating) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
    }
    public static void main(String[] args) {
        Song s=Song.createSong("name1,pop,4.30,5");
        System.out.println(s);
    }
    public static Song createSong(String line){
        Song newSong;
        String[] split = line.split(",");
        String nTitle=split[0];
        String nGenre=split[1];
        Date nDate=new Date();
        String dur=split[2];
        // System.out.println("@"+dur);
        long min=0;
        int i=0;
        for(;i<dur.length();i++){
            if(dur.charAt(i)=='.') break;
            min=min*10+(dur.charAt(i)-'0');
        }
        i++;
        long secs=0;
        for(;i<dur.length();i++){
            if(dur.charAt(i)=='.') break;
            secs=secs*10+(dur.charAt(i)-'0');
        }
        // System.out.println(min);
        // System.out.println(secs);
        nDate.setTime(min*60+secs);
        double nRating=Double.parseDouble(split[3]);
        newSong=new Song(nTitle, nGenre, nDate, nRating);
        return newSong;
    }
}
