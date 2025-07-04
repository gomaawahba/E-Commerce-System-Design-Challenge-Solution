// Gomaa Abdelgawoad Wahba - Fawry Internship Challenge

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {
    public static void ship(List<Shippable> items) {
        double totalWeight = 0;
        System.out.println("** Shipment notice **");
        Map<String, Integer> itemCount = new HashMap<>();
        Map<String, Double> itemWeight = new HashMap<>();

        for (Shippable item : items) {
            itemCount.put(item.getName(), itemCount.getOrDefault(item.getName(), 0) + 1);
            itemWeight.put(item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : itemCount.keySet()) {
            System.out.printf("%dx %s\t%.0fg\n", itemCount.get(name), name, itemWeight.get(name) * 1000);
        }
        System.out.printf("Total package weight %.1fkg\n\n", totalWeight);
    }
}
