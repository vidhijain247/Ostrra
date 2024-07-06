package fourjuly;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Song> allsongs = new ArrayList<>();

        allsongs.add(new Song("Song1", "genre1", "3:00", 3.5));
        allsongs.add(new Song("Song2", "genre2", "2:45", 4.0));
        allsongs.add(new Song("Song3", "genre3", "4:30", 3.8));
        allsongs.add(new Song("Song4", "genre4", "3:25", 4.5));

        System.out.println("Enter choice: \n1= Sort by duration\n2= Sort by rating\n3= Search by title");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                Collections.sort(allsongs, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
                System.out.println("Sorted by duration: " + allsongs);
                break;
            case 2:
                Collections.sort(allsongs, (s1, s2) -> s1.getRating().compareTo(s2.getRating()));
                System.out.println("Sorted by rating: " + allsongs);
                break;
            case 3:
                System.out.println("Enter song title to search the song:");
                String title = sc.nextLine();
                boolean found = false;
                for (Song song : allsongs) {
                    if (song.getTitle().equalsIgnoreCase(title)) {
                        System.out.println("Song found: " + song);
                        found = true;
                        
                        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("song.ser"))) {
                            oos.writeObject(song);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }
                if (!found) {
                    try {
                        throw new SongNotFoundException("Song not found: " + title);
                    } catch (SongNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }

      
    }
}