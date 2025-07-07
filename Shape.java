// Create a Factory Design Pattern in Java to create objects of type Shape (Circle, Square). Include necessary dimensions passed as arguments.
public abstract class Shape {
    // Abstract method to calculate area
    public abstract double calculateArea();

    // Abstract method to calculate perimeter
    public abstract double calculatePerimeter();
}

// Circle class extending Shape
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Square class extending Shape
class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
