import java.util.List;

public class Refactoring {
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
}
