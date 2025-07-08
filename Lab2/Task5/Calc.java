public double calculateTotalWithDiscount(List<Integer> itemPrices, double discountPercentage) {
    double total = 0.0;
    for (int price : itemPrices) {
        total += price;
    }
    total = applyDiscount(total, discountPercentage);
    return total;
}

private double applyDiscount(double amount, double discountPercentage) {
    return amount - amount * (discountPercentage / 100);
}