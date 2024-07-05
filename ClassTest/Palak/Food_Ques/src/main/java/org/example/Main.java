package org.example;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ItemDAO item = new ItemDAO();
        item.addItem(new Item("Wheat", 186.4, "Food"));
        item.addItem(new Item("Fruits", 987.4, "Food"));
        item.addItem(new Item("iPhone", 50056.4, "Object"));
        item.addItem(new Item("Computer", 112456.4, "Object"));

        List<Item>  itemList1;
       itemList1 = item.findItem(176.4);
       itemList1.forEach(System.out::println);

        List<Item> itemList2;
        itemList2 = item.findItem("Computer");
        itemList2.forEach(System.out::println);

    }
}


