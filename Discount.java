import java.util.List;

public class Discount {
    private double percentage;

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
}
