package lab_20250707;
// filepath: /Users/phamvietkhoa/learning-code/fpt-coding/training_2025/FSAF1GCopilotSpringBootLabs/Circle.java
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
