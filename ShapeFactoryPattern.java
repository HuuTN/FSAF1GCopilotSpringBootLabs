// Abstract class
public abstract class Shape {
    public abstract double calculateArea();
}

// Concrete classes
public class Circle extends Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    @Override
    public double calculateArea() { return Math.PI * radius * radius; }
}

public class Square extends Shape {
    private double side;
    public Square(double side) { this.side = side; }
    @Override
    public double calculateArea() { return side * side; }
}