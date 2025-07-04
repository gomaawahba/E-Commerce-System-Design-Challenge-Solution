// Gomaa Abdelgawoad Wahba - Fawry Internship Challenge

public class Product {

    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return false;
    }

    public boolean isAvailable(int amount) {
        return quantity >= amount && !isExpired();
    }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
