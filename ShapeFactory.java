public class ShapeFactory {
    public static Shape createShape(String type, double dimension) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle(dimension);
        } else if (type.equalsIgnoreCase("square")) {
            return new Square(dimension);
        } else {
            throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
