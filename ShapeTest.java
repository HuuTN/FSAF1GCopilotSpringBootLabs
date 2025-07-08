public class ShapeTest {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Create a circle with radius 5
        Shape circle = shapeFactory.createShape("circle", 5.0);
        circle.draw();
        System.out.println("Circle area: " + circle.getArea());

        // Create a square with side length 4
        Shape square = shapeFactory.createShape("square", 4.0);
        square.draw();
        System.out.println("Square area: " + square.getArea());
    }
}
