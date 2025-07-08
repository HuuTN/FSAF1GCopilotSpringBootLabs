import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class Counter {
    public double calculateTotalWithDiscount(List<Integer> itemPrices, double discountPercentage) {
        double total = 0;
        for (int price : itemPrices) {
            total += price;
        }
        return applyDiscount(total, discountPercentage);
    }

    private double applyDiscount(double total, double discountPercentage) {
        return total - (total * (discountPercentage / 100));
    }

    public List<String> sortNames(List<String> names) {
        return names.stream()
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .collect(Collectors.toList());
    }
}
