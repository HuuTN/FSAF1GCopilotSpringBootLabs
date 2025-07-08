package lab_20250707;
// filepath: /Users/phamvietkhoa/learning-code/fpt-coding/training_2025/FSAF1GCopilotSpringBootLabs/Square.java
public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
