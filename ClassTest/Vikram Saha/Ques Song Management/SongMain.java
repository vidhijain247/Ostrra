import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SongMain {
public static void main(String[] args) throws IOException {
    List<Song> songList=new ArrayList<Song>();

    songList.add(Song.createSong("song1,pop,3.40,4"));
    songList.add(Song.createSong("song2,pop,1.40,1"));
    songList.add(Song.createSong("song3,jazz,2.40,3"));
    songList.add(Song.createSong("song4,rock,4.40,2"));
    songList.add(Song.createSong("song5,rock,7.40,5"));

    Scanner sc = new Scanner(System.in);
    System.out.println("enter choice");
    int choice= sc.nextInt();
    if(choice==1){
        Collections.sort(songList,(a,b)->{
            if( a.getActualDuration() < b.getActualDuration()) return -1;
            else return 1;
        });
        songList.forEach(System.out::println);
    }
    else if(choice==2){
        Collections.sort(songList,(a,b)->{
            if( a.getRating() < b.getRating()) return -1;
            else return 1;
        });
        songList.forEach(System.out::println);
    }
    else{
        FileOutputStream fos=new FileOutputStream("songOBJ");
        ObjectOutputStream oos=new ObjectOutputStream(fos);


        System.out.println("ENTER SONG NAME YOU WANT TO SEARCH");
        String keySong="song3";
        songList.stream().filter(a->a.getTitle().equals(keySong)).findFirst().ifPresentOrElse(a->{
            System.out.println(a);
            try {
                oos.writeObject(a);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }, ()->{try {
            throw new SongNotFoundException();
        } catch (SongNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }});
    }
}
}
