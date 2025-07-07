interface Shape {
    double area();
}

class Circle implements Shape {
    private double radius;
    public Circle(double radius) { this.radius = radius; }
    public double area() { return Math.PI * radius * radius; }
}

class Square implements Shape {
    private double side;
    public Square(double side) { this.side = side; }
    public double area() { return side * side; }
}

class ShapeFactory {
    public static Shape createShape(String type, double... params) {
        switch (type) {
            case "Circle":
                if (params.length == 1) return new Circle(params[0]);
                throw new IllegalArgumentException("Circle requires 1 parameter (radius)");
            case "Square":
                if (params.length == 1) return new Square(params[0]);
                throw new IllegalArgumentException("Square requires 1 parameter (side)");
            default:
                throw new IllegalArgumentException("Unknown shape type");
        }
    }
}
