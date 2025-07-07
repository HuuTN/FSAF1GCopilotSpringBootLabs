package src.factory;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Render a checkbox in Windows style.");
    }
}
