package com.example.employeeservice;

public class ShapeFactory {
    public static Shape createShape(String type, double... dimensions) {
        switch (type.toLowerCase()) {
            case "circle":
                if (dimensions.length != 1) {
                    throw new IllegalArgumentException("Circle requires 1 dimension: radius");
                }
                return new Circle(dimensions[0]);
            case "square":
                if (dimensions.length != 1) {
                    throw new IllegalArgumentException("Square requires 1 dimension: side");
                }
                return new Square(dimensions[0]);
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}
