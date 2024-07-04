import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Song> songs = new ArrayList<>();

       
        String[] songDetails = {
            "chammak challo,classical,300000,4.2",
            "baarishein,Rock,240000,4.1",
            "riha,Jazz,360000,4.3",
            "redrum1,pop,180000,4.9"
        };

        for (String detail : songDetails) {
            songs.add(Song.createSong(detail));
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter choice: \n1. Sort by duration\n2. Sort by rating\n3. Search song by title");
        int choice = sc.nextInt();
        sc.nextLine(); 

        switch (choice) {
            case 1:
               
                Collections.sort(songs, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
                break;
            case 2:
                
                Collections.sort(songs, (s1, s2) -> Double.compare(s1.getRating(), s2.getRating()));
                break;
            case 3:
              
                String searchName = "Song3"; 
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

