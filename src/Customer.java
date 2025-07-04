// Gomaa Abdelgawoad Wahba - Fawry Internship Challenge

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean hasEnough(double amount) {
        return balance >= amount;
    }

    public void deduct(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

