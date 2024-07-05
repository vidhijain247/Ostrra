package com.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws SQLException {
    List<Item> itemList = prefillItems(); 

    ItemDAO itemDAO = new ItemDAO();

    // Add items to database
    itemDAO.bulkCopy(itemList);

    // Search menu
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("Search Menu:");
      System.out.println("1. Search by Type");
      System.out.println("2. Search by Price");
      System.out.println("3. Add new Item");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter the type to search: ");
          String searchType = scanner.next();
          List<Item> foundItemsByType = itemDAO.findItem(searchType);

          if (foundItemsByType.isEmpty()) {
            System.out.println("No such item is present");
          } else {
            System.out.format("%-20s %-5s %s\n", "Name", "Price", "Type");
            for (Item item : foundItemsByType) {
              System.out.println(item);
            }
          }
          break;
        case 2:
          System.out.print("Enter the price to search: ");
          Double searchPrice = scanner.nextDouble();
          List<Item> foundItemsByPrice = itemDAO.findItem(searchPrice);

          if (foundItemsByPrice.isEmpty()) {
            System.out.println("No such item is present");
          } else {
            System.out.format("%-20s %-5s %s\n", "Name", "Price", "Type");
            for (Item item : foundItemsByPrice) {
              System.out.println(item);
            }
          }
          break;
          case 3:
          System.out.println("Enter details of the new item:");
          System.out.print("Name: ");
          String newName = scanner.next();
          System.out.print("Price: ");
          Double newPrice = scanner.nextDouble();
          System.out.print("Type: ");
          String newType = scanner.next();

          Item newItem = new Item(newName, newPrice, newType);
          itemDAO.addItem(newItem);
          System.out.println("Item added successfully!");
          break;
        case 4:
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("Invalid choice");
      }
    } while (choice != 4);


    scanner.close();
  }

  public static List<Item> prefillItems() {
    List<Item> items = new ArrayList<>();

    return items;
  }
}

