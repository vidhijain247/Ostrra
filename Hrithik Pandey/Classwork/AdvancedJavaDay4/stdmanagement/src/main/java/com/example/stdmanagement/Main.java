package com.example.stdmanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  try (FileOutputStream fos = new FileOutputStream("newfile.txt")) {
        //     String content = "Hello, World!";
        //     fos.write(content.getBytes());
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        Properties properties = new Properties();
           try (FileInputStream fis = new FileInputStream("db.properties")){
             properties.load(fis);
         } catch (IOException e) {
             e.printStackTrace();
         }
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USER");
        String password = properties.getProperty("PASSWORD");
        Scanner scanner = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            while(true){
            System.out.println("Choose an operation: 1. Create 2. Insert 3. Update 4. Delete");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                switch (choice) {
                    case 1:
                        createTable(conn);
                        break;
                    case 2:
                       insertRecord(conn, scanner);
                        break;
                    case 3:
                    updateRecord(conn, scanner);
                    break;
                    case 4:
                    deleteRecord(conn, scanner);
                    break;
                    case 5:
                    return;
                    default:
                    System.out.println("Invalid choice. Try again.");
                }
            }
            }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    private static void createTable(Connection conn) throws SQLException {
        
        String createTableSQL = "CREATE TABLE std ("
                + "id INT PRIMARY KEY, "
                + "name VARCHAR(100), "
                + "marks INT)";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table created successfully.");
        }
    }

    private static void insertRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter marks: ");
        int marks = scanner.nextInt();
        scanner.nextLine();

        String insertSQL = "INSERT INTO std (id,name, marks) VALUES (?,?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setInt(1, marks);
            pstmt.setString(2, name);
            pstmt.setInt(3, marks);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        }
    }
    private static void updateRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new marks: ");
        int marks = scanner.nextInt();

        String updateSQL = "UPDATE std SET name = ?, marks = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, marks);
            pstmt.setInt(3, id);
            int r= pstmt.executeUpdate();
                System.out.println("Record updated successfully.");
        }
    }

    private static void deleteRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        String deleteSQL = "DELETE FROM std WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
            pstmt.setInt(1, id);
            int i = pstmt.executeUpdate();
                System.out.println("No record found with the given ID.");
            }
            catch(Exception e){

            }
        }
    
}