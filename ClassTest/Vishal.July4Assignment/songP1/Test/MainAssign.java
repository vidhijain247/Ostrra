package Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class MainAssign {
    public static void main(String[] args) {
        System.out.println("Hello, welcome !!!    \n");
        Scanner sc = new Scanner(System.in);
        List<Song> songs = new ArrayList<>();

        songs.add(new Song("s1", "English", "3:45", 9.3));
        songs.add(new Song("s2", "Hindi", "4:20", 6.0));
        songs.add(new Song("s3", "Punjabi", "5:00", 9.0));
        songs.add(new Song("s4", "Haryanvi", "2:00", 10.0));

        System.out.println("HI,   Welcome......");

        System.out.println();
        System.out.println();

        int enteredChoice;
        do {
            System.out.println("Enter Choice: \n1. Sorting by duration\n2. Sorting by rating\n3. Searching song by titles\n0. For exiting.....");
            enteredChoice = sc.nextInt();
            sc.nextLine(); 

            switch (enteredChoice) {
                case 0:
                    System.out.println("Exiting...");
                    break;
                case 1:
                    Collections.sort(songs, (s1, s2) -> s1.getDuration().compareTo(s2.getDuration()));
                    System.out.println("Sorted by duration: " + songs);
                    break;
                case 2:
                    Collections.sort(songs, (s1, s2) -> s1.getRating().compareTo(s2.getRating()));
                    System.out.println("Sorted by rating: " + songs);
                    break;
                case 3:
                    System.out.println("Enter song title to search:");
                    String title = sc.nextLine();
                    boolean found = false;
                    for (Song song : songs) {
                        if (song.gettitles().equalsIgnoreCase(title)) {
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
                            throw new SongNotFoundException("Song not present -: " + title);
                        } catch (SongNotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter a valid Choice.");
                    break;
            }
        } while (enteredChoice != 0);

        sc.close();
    }
}
