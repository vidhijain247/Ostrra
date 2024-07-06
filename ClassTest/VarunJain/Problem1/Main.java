import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class Song implements Serializable {
    private String title;
    private String genre;
    private Date duration;
    private Double rating;
    private SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:yy");

    public Song() {
    }

    public Song(String title, String genre, String duration, Double rating) {
        this.title = title;
        this.genre = genre;
        try {
            this.duration = dateformat.parse(duration);
        } catch (ParseException e) {
            System.err.println( e.getMessage());
        }
        this.rating = rating;
    }
    

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return dateformat.format(duration);
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
        this.duration = dateformat.parse(duration);    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public static Song createSong(String line) {
        String[] parts = line.split(",");
        return new Song(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }

    public String toString() {
        return "Song [title=" + title + ", genre=" + genre + ", duration=" + duration + ", rating=" + rating + "]";
    }
}

public class Main {

    public static void menu() {
        System.out.println("Enter choice: ");
        System.out.println("1. Sort by duration");
        System.out.println("2. Sort by rating");
        System.out.println("3. Search song by title");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Song> songs = new ArrayList<>();

        songs.add(new Song("S1", "aaa", "01:01:2024", 4.7));
        songs.add(new Song("s2", "bb", "04:02:2024", 4.9));
        songs.add(new Song("s3", "ccc", "06:08:2024", 4.0));

        int choice;
        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    Collections.sort(songs, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
                    System.out.println(songs);
                    break;
                case 2:
                    Collections.sort(songs, (s1, s2) -> s1.getRating().compareTo(s2.getRating()));
                    System.out.println(songs);
                    break;
                case 3:
                    System.out.println("Enter song title: ");
                    String title = sc.nextLine();
                    boolean found = false;
                    for (Song song : songs) {
                        if (song.getTitle().equals(title)) {
                            System.out.println("Song found: " + song);
                            found = true;
                            break; 
                        }
                    }
                    if (!found) {
                        System.out.println("Song not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

       
    }
}
