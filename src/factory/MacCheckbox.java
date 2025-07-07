package src.factory;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Render a checkbox in Mac style.");
    }
}
