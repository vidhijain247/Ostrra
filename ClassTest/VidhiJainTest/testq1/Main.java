package testq1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {public static void main(String[] args) {
    List<Song> songs = new ArrayList<>();

    
    String[] songDetails = {
        "Sawaria,Bollywood,300000,4.5",
        "Mai hoo na,Rock,240000,4.7",
        "Tu aake dekh le,Jazz,360000,4.3",
        "Lover,Jazz,180000,4.8"
    };

    for (String detail : songDetails) {
        songs.add(Song.createSong(detail));
    }

     
    int choice;
    System.out.println("Enter your choice (1,2,3): ");
    Scanner s = new Scanner(System.in);
    choice = s.nextInt();

    //int choice = 2; 
    switch (choice) {
        case 1:
            // Sort by duration
            Collections.sort(songs, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
            break;
        case 2:
            // Sort by rating
            Collections.sort(songs, (s1, s2) -> Double.compare(s1.getRating(), s2.getRating()));
            break;
        case 3:
            // Search by name
            String searchName = "Lover"; 
            boolean found = false;
            for (Song song : songs) {
                if (song.getTitle().equalsIgnoreCase(searchName)) {
                    System.out.println("Song found: " + song);
                    found = true;

                    
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("song.dat"))) {
                        oos.writeObject(song);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                }
            }
            if (!found) {
                System.out.println("SongNotFoundException");
            }
            return; 
        default:
            System.out.println("Invalid choice");
            return;
    }

    
    System.out.printf("%-20s %-10s %-12s %-12s\n", "Title", "Genre", "Duration", "Rating");
    for (Song song : songs) {
        System.out.println(song);
    }
}
}
