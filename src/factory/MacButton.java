package src.factory;

public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Render a button in Mac style.");
    }
}
