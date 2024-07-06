package Songs;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void menu() {
        System.out.println("Enter choice: ");
        System.out.println("1. Sort by duration");
        System.out.println("2. Sort by rating");
        System.out.println("3. Song by title");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) throws ParseException {
        try (Scanner sc = new Scanner(System.in)) {
			List<Song> songs = new ArrayList<>();

			songs.add(new Song("NightChanges", "Soft", "00:03:03", 4.7));
			songs.add(new Song("Goodbye", "Rock", "00:04:01", 4.9));
			songs.add(new Song("Hello", "Love", "00:01:00", 4.0));

			int choice;
			do {
			    menu();
			    choice = sc.nextInt();
			    sc.nextLine();

			    switch (choice) {
			        case 1:
			            Collections.sort(songs, Comparator.comparing(Song::getDuration));
			            System.out.println(songs);
			            break;
			        case 2:
			            Collections.sort(songs, Comparator.comparing(Song::getRating));
			            System.out.println(songs);
			            break;
			        case 3:
			            System.out.println("Enter song title: ");
			            String title = sc.nextLine();
			            boolean found = false;
			            for (Song song : songs) {
			                if (song.getTitle().equalsIgnoreCase(title)) {
			                    System.out.println("Song found: " + song);
			                    found = true;
			                    break;
			                }
			            }
			            if (!found) {
			                System.out.println("Song not found.");
			            }
			            break;
			        case 4:
			            System.out.println("Exiting");
			            break;
			        default:
			            System.out.println("Invalid choice.");
			    }
			} while (choice != 4);
		}
    }
}
