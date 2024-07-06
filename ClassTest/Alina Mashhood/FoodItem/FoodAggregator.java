import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class FoodAggregator {
    public static void main(String[] args) {
        ItemDAO itemDAO = new ItemDAO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of items:");
        int numberOfItems = scanner.nextInt();
        scanner.nextLine(); 
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("Enter item details (name,price,type): ");
            String itemDetails = scanner.nextLine();
            String[] details = itemDetails.split(",");
            Item item = new Item(details[0], Double.parseDouble(details[1]), details[2]);
            itemList.add(item);
        }
        itemDAO.bulkCopy(itemList);
        System.out.println("Enter choice (1: Search by Type, 2: Search by Price): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        List<Item> searchResults = null;
        switch (choice) {
            case 1:
                System.out.println("Enter item type: ");
                String type = scanner.nextLine();
                searchResults = itemDAO.findItem(type);
                break;
            case 2:
                System.out.println("Enter item price: ");
                Double price = scanner.nextDouble();
                searchResults = itemDAO.findItem(price);
                break;
            default:
                System.out.println("Invalid choice");
                scanner.close();
                return; 
        }
        if (searchResults != null && !searchResults.isEmpty()) {
            System.out.format("%-20s %-5s %s\n", "Name", "Price", "Type");
            for (Item item : searchResults) {
                System.out.println(item);
            }
        } else {
            System.out.println("No matching item is present");
        }
        scanner.close();
    }
}

