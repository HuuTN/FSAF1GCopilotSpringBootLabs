public class ShapeFactory {
    public static Shape createShape(String type, double dimension) {
        switch (type.toLowerCase()) {
            case "circle":
                return new Circle(dimension);
            case "square":
                return new Square(dimension);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
