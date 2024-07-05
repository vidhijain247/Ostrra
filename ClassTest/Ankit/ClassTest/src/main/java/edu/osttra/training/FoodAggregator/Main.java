package edu.osttra.training.FoodAggregator;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ItemDAO item = new ItemDAO();
        item.addItem(new Item("Rice", 176.4, "Food"));
        item.addItem(new Item("Steel", 676.4, "Material"));
        item.addItem(new Item("Table", 1376.4, "Object"));
        item.addItem(new Item("Laptop", 1576.4, "Computer"));

        List<Item> result1;
        result1 = item.findItem(176.4);
        result1.forEach(System.out::println);

        List<Item> result2;
        result2 = item.findItem("Computer");
        result2.forEach(System.out::println);

    }
}
