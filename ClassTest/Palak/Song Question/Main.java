import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Song> songList = new ArrayList<>();


        System.out.println("Enter the number of songs :");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("Enter song details :");
            String songDetails = sc.nextLine();
            try {
                Song s = Song.createSong(songDetails);
                songList.add(s);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("1. Sort by duration");
        System.out.println("2. Sort by rating");
        System.out.println("3. For Search");
        System.out.println("Enter your choice:");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
            Collections.sort(songList, Comparator.comparing(Song::getDuration));
                break;
            case 2:
            Collections.sort(songList, Comparator.comparing(Song::getRating));
            break;
            case 3:
            System.out.println("Enter song to search:");
            String searchTitle = sc.nextLine();
            List<Song> foundSongs = songList.stream()
                    .filter(song -> song.getTitle().equalsIgnoreCase(searchTitle))
                    .toList();
            if (!foundSongs.isEmpty()) {
                foundSongs.forEach(song -> {
                    System.out.format("%-20s %-10s %-12s %-12s\n", "Title", "Genre", "Duration", "Rating");
                    System.out.format("%-20s %-10s %-12s %-12s\n", song.getTitle(), song.getGenre(), song.getDuration(), song.getRating());});
                }
                else{
                    System.out.println("Song '" + searchTitle + "' not found.");
                }
                break;
                default:
                    System.out.println("Invalid choice");
            }

            sc.close();
        
    
    class SongNotFoundException extends RuntimeException {
        public SongNotFoundException(String message) {
            super(message);
        }
    }

}
     }





