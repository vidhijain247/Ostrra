package com.foodagg;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ItemDAO.addItem(new Item("Item1",100.0,"typeA"));
        ItemDAO.addItem(new Item("Item2",60.0,"typeB"));
        ItemDAO.addItem(new Item("Item3",400.0,"typeC"));

        ItemDAO.findItem(100).forEach(System.out::println);
        ItemDAO.findItem("typeC").forEach(System.out::println);
        
    }
}