// Gomaa Abdelgawoad Wahba - Fawry Internship Challenge

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Gomaa", 1000);

        Product cheese = new ExpirableShippableProduct("Cheese", 100, 5, LocalDate.of(2025, 7, 30), 0.2);
        Product biscuits = new ExpirableShippableProduct("Biscuits", 150, 2, LocalDate.of(2025, 7, 20), 0.7);
        Product tv = new ShippableProduct("TV", 400, 3, 4);
        Product scratchCard = new SimpleProduct("Scratch Card", 50, 10);

        List<CartItem> cart = new ArrayList<>();
        cart.add(new CartItem(cheese, 2));
        cart.add(new CartItem(biscuits, 1));
        cart.add(new CartItem(tv, 1));
        cart.add(new CartItem(scratchCard, 1));

        Checkout.process(customer, cart);
    }
}