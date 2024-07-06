package foodques;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ItemDAO.addItem(new Item("Item1",100.0,"type1"));
        ItemDAO.addItem(new Item("Item2",60.0,"type2"));
        ItemDAO.addItem(new Item("Item3",400.0,"type3"));

        ItemDAO.findItem(60).forEach(System.out::println);
        ItemDAO.findItem("type2").forEach(System.out::println);
        
    }
}
