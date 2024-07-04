package foodques;

public class Item {
private String name;
private double price;
private String type;
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public double getPrice() {
    return price;
}
public void setPrice(double price) {
    this.price = price;
}
public String getType() {
    return type;
}
public void setType(String type) {
    this.type = type;
}
public Item(String name, double price, String type) {
    this.name = name;
    this.price = price;
    this.type = type;
}
public Item() {
}
@Override
public String toString() {
    return String.format("%-20s %-5s %s\n", name, price, type);
}


}
