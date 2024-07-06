
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class main {
    public static void main(String[] args) throws ParseException {
        List<Song> songs= new ArrayList<>();
        songs.add(new Song().createSong("Lost,pop,3.28,4"));
        songs.add(new Song().createSong("Nice,hiphop,3.00,2"));
        songs.add(new Song().createSong("metal,rock,1.3,1"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an operation: 1. 2. 3. 4.");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        sortSongs(songs);
                        break;
                    case 2:
                        sortSongsRating(songs);
                        break;
                    case 3:
                    System.out.println("Enter Song Name");
                    String find = scanner.nextLine();
                    searchSongByTitle(songs,find);
                    break;
                    default:
                    System.out.println("go away");
                }
    }
    static void sortSongs(List<Song>songs){
        Collections.sort(songs, new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return s1.getDuration().compareTo(s2.getDuration());
            }
        });
        for (Song song : songs) {
            System.out.println(song);
        }
    }
    static void sortSongsRating(List<Song>songs){
        Collections.sort(songs, new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return s1.getRating().compareTo(s2.getRating());
            }
        });
        for (Song song : songs) {
            System.out.println(song);
        }
    }
    public static void searchSongByTitle(List<Song> songs, String title) {
       try{
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                System.out.println(song);
                break;
            }
            else
            throw new SongNotFound();
        }
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("songs.txt"))) {
                    out.writeObject(songs);
                } catch (IOException e) {
                    e.printStackTrace();
                    }
            }
        catch (SongNotFound e) {
            System.out.println(e.getMessage());
        }
        
    }
}
