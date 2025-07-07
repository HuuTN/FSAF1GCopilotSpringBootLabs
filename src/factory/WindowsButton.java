package src.factory;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Render a button in Windows style.");
    }
}
