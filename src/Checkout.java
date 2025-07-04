// Gomaa Abdelgawoad Wahba - Fawry Internship Challenge

import java.util.ArrayList;
import java.util.List;

public class Checkout {
    public static void process(Customer customer, List<CartItem> cart) {
        if (cart.isEmpty()) throw new RuntimeException("Cart is empty!");

        double subtotal = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (CartItem item : cart) {
            if (!item.product.isAvailable(item.quantity))
                throw new RuntimeException("Product out of stock or expired: " + item.product.getName());

            subtotal += item.product.getPrice() * item.quantity;
            item.product.reduceQuantity(item.quantity);

            if (item.product instanceof Shippable) {
                for (int i = 0; i < item.quantity; i++)
                    toShip.add((Shippable) item.product);
            }
        }

        double shipping = toShip.isEmpty() ? 0 : 30;
        double total = subtotal + shipping;

        if (!customer.hasEnough(total))
            throw new RuntimeException("Insufficient balance!");

        customer.deduct(total);

        if (!toShip.isEmpty()) ShippingService.ship(toShip);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart) {
            System.out.printf("%dx %s\t%.0f\n", item.quantity, item.product.getName(), item.product.getPrice() * item.quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal\t\t%.0f\n", subtotal);
        System.out.printf("Shipping\t\t%.0f\n", shipping);
        System.out.printf("Amount\t\t%.0f\n", total);
        System.out.printf("Remaining Balance\t%.0f\n", customer.getBalance());
    }
}
