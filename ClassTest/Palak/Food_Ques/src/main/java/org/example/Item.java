package org.example;

public class Item {
    private String name;
    private Double price;
    private String type;


    public Item(String name, Double price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return String.format("%-20s %-5.1f %s", name, price, type);
    }
}

