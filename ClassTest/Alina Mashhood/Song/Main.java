import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Song> songList = new ArrayList<>();

        songList.add(Song.createSong("Song1,Pop,03:45,4.5"));
        songList.add(Song.createSong("Song2,Rock,04:20,4.8"));
        songList.add(Song.createSong("Song3,Jazz,02:30,4.2"));
        songList.add(Song.createSong("Song4,Classical,05:00,4.7"));
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter choice (1: Sort by Duration, 2: Sort by Rating, 3: Search Song): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                Collections.sort(songList, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
                break;
            case 2:
                Collections.sort(songList, (s1, s2) -> s1.getRating().compareTo(s2.getRating()));
                break;
            case 3:
                System.out.println("Enter song title to search: ");
                String title = scanner.nextLine();
                try {
                    Song foundSong = searchSong(songList, title);
                    System.out.println("Song found:");
                    System.out.println(foundSong);
                    serializeSong(foundSong);
                } catch (SongNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                scanner.close();
                return; 
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return; 
        }

        System.out.format("%-20s %-10s %-12s %-12s\n", "Title", "Genre", "Duration", "Rating");
        for (Song song : songList) {
            System.out.println(song);
        }

        scanner.close();
    }
    
    public static Song searchSong(List<Song> songList, String title) throws SongNotFoundException {
        for (Song song : songList) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        throw new SongNotFoundException("Song with title " + title + " not found.");
    }
    
    public static void serializeSong(Song song) {
        try (FileOutputStream fileOut = new FileOutputStream(song.getTitle() + ".ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(song);
            System.out.println("Serialized data is saved in " + song.getTitle() + ".ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

class SongNotFoundException extends Exception {
    public SongNotFoundException(String message) {
        super(message);
    }
}

