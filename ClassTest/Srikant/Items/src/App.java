import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String itemsString = "Item1,10.5,Type1;Item2,20.75,Type2;Item3,14.5,Type2";
        List<Item> items = parseItems(itemsString);
        
        ItemDAO itemDAO = new ItemDAO();
        itemDAO.bulkCopy(items);

        List<Item> foundItemsByType = itemDAO.findItem("Type1");
        System.out.println("Items found by type 'Type1':");
        for (Item item : foundItemsByType) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }

        List<Item> foundItemsByPrice = itemDAO.findItem(20.75);
        System.out.println("\nItems found by price $20.75:");
        for (Item item : foundItemsByPrice) {
            System.out.println(item.getName() + " - Type: " + item.getType());
        }
    }

    private static List<Item> parseItems(String itemsString) {
        List<Item> items = new ArrayList<>();
        String[] itemEntries = itemsString.split(";");
        for (String itemEntry : itemEntries) {
            String[] parts = itemEntry.split(",");
            if (parts.length == 3) {
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                String type = parts[2];
                Item item = new Item(name, price, type);
                items.add(item);
            }
        }
        return items;
    }
}
