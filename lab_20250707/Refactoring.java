package lab_20250707;
import java.util.List;

public class Refactoring {
    //Task 5
    //Promt Extract Method: // Extract the discount calculation into a separate private method
    public double calculateTotalWithDiscount(List<Integer> itemPrices, double discountPercentage) {
        double total = 0;
        for (int price : itemPrices) {
            total += price;
        }
        total = applyDiscount(total, discountPercentage);
        return total;
    }

    private double applyDiscount(double total, double discountPercentage) {
        return total - (total * (discountPercentage / 100));
    }

    //Task 6
    // Promt Optimize Sorting: // Optimize the sortNames method to use Java Streams for case-insensitive sorting
    public List<String> sortNames(List<String> names) {
        return names.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .toList();
    }
}
