package edu.osttra.training.SongManagement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the choice number");
        int choice = sc.nextInt();
        List<Song> obj = new ArrayList<>();

        obj.add(Song.createSong("sad,hip-hop,03.30,5"));
        obj.add(Song.createSong("happy,hip-hop,04.30,4"));
        obj.add(Song.createSong("romantic,hip-hop,02.30,7"));
        obj.add(Song.createSong("sad,hip-hop,01.30,1"));

        if(choice == 1) {
            // based on duration
            Collections.sort(obj, (r1, r2) -> r1.getDuration().compareTo(r2.getDuration()));
            obj.forEach(System.out::println);
        } else if(choice == 2) {
            // sort based on rating
            Collections.sort(obj, (s1, s2)-> {
                if(s1.getRating() < s2.getRating()) {
                    return -1;
                } else {
                    return 1;
                }
            });
            obj.forEach(System.out::println);
        } else if(choice == 3) {
            // search by title
            File file = new File("Object.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            System.out.println("Enter song name to search");
            String song = sc.nextLine();
            obj.stream().filter(o -> o.getTitle().equalsIgnoreCase(song)).findFirst().ifPresentOrElse((result)->{
                try{
                    System.out.println("Song Details");
                    System.out.println("Song name: "+result.getTitle()+", Song genre: "+result.getGenre()+", Duration: "+result.getDuration()+", Rating: "+result.getRating());
                    oos.writeObject(result);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }, ()-> {
                try {
                    throw new SongNotFound();
                } catch (SongNotFound e) {
                    System.out.println(e.getMessage());
                }
            });

        }
    }
}
