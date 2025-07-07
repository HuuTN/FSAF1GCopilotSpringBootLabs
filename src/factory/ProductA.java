package src.factory;

public class ProductA implements Product {
    @Override
    public void create() {
        System.out.println("Product A created.");
    }
}
