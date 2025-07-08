public class ShapeFactory {
    // Factory method to create shape objects
    public Shape createShape(String shapeType, double... dimensions) {
        if (shapeType == null) {
            return null;
        }
        
        switch (shapeType.toLowerCase()) {
            case "circle":
                if (dimensions.length > 0) {
                    return new Circle(dimensions[0]); // radius
                }
                break;
                
            case "square":
                if (dimensions.length > 0) {
                    return new Square(dimensions[0]); // side length
                }
                break;
        }
        
        throw new IllegalArgumentException("Invalid shape type or dimensions");
    }
}
