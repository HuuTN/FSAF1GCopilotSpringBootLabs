public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square with side length: " + side);
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
