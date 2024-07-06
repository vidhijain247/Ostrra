package FoodP3;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void prefill(List<Items> items) {
    	items.add(new Items("All-Burger", 110.0, "Food"));
    	items.add(new Items("Samosa", 40.0, "Food"));
    	items.add(new Items("Limeca", 50.0, "Drink"));
        items.add(new Items("Biryani", 100.0, "Food"));
        items.add(new Items("Jaljerra", 50.0, "Drink"));
       
    }

    public static void menu() {
        System.out.println("Enter choice: ");
        System.out.println("1. Search by type");
        System.out.println("2. Search by price");
        System.out.println("3. Exit");
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ConnectionMain jdbcMain = new ConnectionMain();
        List<Items> items = new ArrayList<>();

        prefill(items);
        jdbcMain.bulkCopy(items);

        System.out.println("HI,   Welcome......");

        System.out.println();
        System.out.println();

        int choice;
        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter item type: ");
                    String type = sc.nextLine();
                    List<Items> itemsByType = jdbcMain.findItem(type);
                    if (itemsByType.isEmpty()) {
                        System.out.println("No such item is present");
                    } else {
                        System.out.format("%-20s %-5s %s\n", "Name", "Price", "Type");
                        for (Items item : itemsByType) {
                            System.out.format("%-20s %-5.1f %s\n", item.getName(), item.getPrice(), item.getType());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter item price: ");
                    Double price = sc.nextDouble();
                    List<Items> itemsByPrice = jdbcMain.findItem(price);
                    if (itemsByPrice.isEmpty()) {
                        System.out.println("No such item is present");
                    } else {
                        System.out.format("%-20s %-5s %s\n", "Name", "Price", "Type");
                        for (Items item : itemsByPrice) {
                            System.out.format("%-20s %-5.1f %s\n", item.getName(), item.getPrice(), item.getType());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 3);

        sc.close();
    }
}
