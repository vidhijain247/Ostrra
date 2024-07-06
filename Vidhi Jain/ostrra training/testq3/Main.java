package testq3;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void prefill(List<FoodItem> items) {
    	items.add(new FoodItem("Pizza", 110.0, "Food"));
    	items.add(new FoodItem("Burger", 40.0, "Food"));
    	items.add(new FoodItem("Coke", 50.0, "Drink"));
        items.add(new FoodItem("Rajma Chawal", 100.0, "Food"));
        items.add(new FoodItem("Dosa", 85.0, "Food"));
        items.add(new FoodItem("NimbuSoda", 50.0, "Drink"));
       
    }

    public static void menu() {
        System.out.println("Enter choice: ");
        System.out.println("1. Search by type");
        System.out.println("2. Search by price");
        System.out.println("3. Exit");
    }

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        SqlMain jdbcMain = new SqlMain();
        List<FoodItem> items = new ArrayList<>();

        prefill(items);
        jdbcMain.bulkCopy(items);

        int choice;
        do {
            menu();
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter item type: ");
                    String type = sc.nextLine();
                    List<FoodItem> itemsByType = jdbcMain.findItem(type);
                    if (itemsByType.isEmpty()) {
                        System.out.println("No such item is present");
                    } else {
                        System.out.format("%-20s %-5s %s\n", "Name", "Price", "Type");
                        for (FoodItem item : itemsByType) {
                            System.out.format("%-20s %-5.1f %s\n", item.getName(), item.getPrice(), item.getType());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter item price: ");
                    Double price = sc.nextDouble();
                    List<FoodItem> itemsByPrice = jdbcMain.findItem(price);
                    if (itemsByPrice.isEmpty()) {
                        System.out.println("No such item is present");
                    } else {
                        System.out.format("%-20s %-5s %s\n", "Name", "Price", "Type");
                        for (FoodItem item : itemsByPrice) {
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
