import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class App {
    private static void serializeSong(Song song, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(song);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(System.in);
            List<Song> playlist = new ArrayList<>();
            
            playlist.add(Song.createSong("mine,pop,00:03:13,8.4"));
            playlist.add(Song.createSong("supernova,pop,00:02:59,9.2"));
            playlist.add(Song.createSong("armagedon,pop,00:03:16,9.8"));
            playlist.add(Song.createSong("set the tone,pop,00:03:23,8.8"));
            System.out.println("enter an option");

            int response = sc.nextInt();
            switch(response){
                case 1: Collections.sort(playlist, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
                        playlist.forEach((s)->System.out.println(s.toString()));
                        break;
                case 2: Collections.sort(playlist, (s1, s2) -> Double.compare(s2.getRating(), s1.getRating()));
                        playlist.forEach((s)->System.out.println(s.toString()));
                        break;
                case 3: System.out.println("Enter song name - ");
                        String songName = sc.nextLine();

                        Optional<Song> foundSong = playlist.stream().filter(s -> s.getTitle().equals(songName)).findFirst();

                        if (foundSong.isPresent()) {
                            Song song = foundSong.get();
                            serializeSong(song, "found_song.ser");
                            System.out.println("Song found and serialized: " + song);
                        } else {
                            throw new SongNotFoundException("Song not found: " + songName);
                        }
                        break;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class SongNotFoundException extends Exception {
    public SongNotFoundException(String message) {
        super(message);
    }
}