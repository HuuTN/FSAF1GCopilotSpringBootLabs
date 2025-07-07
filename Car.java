//Create a CarBuilder Pattern for constructing a Car object with fields brand, engineSize, color, and seatCount.
public class Car {
    private String brand;
    private double engineSize;
    private String color;
    private int seatCount;

    // Private constructor to enforce the use of the builder
    private Car(CarBuilder builder) {
        this.brand = builder.brand;
        this.engineSize = builder.engineSize;
        this.color = builder.color;
        this.seatCount = builder.seatCount;
    }

    // Getters for the fields
    public String getBrand() {
        return brand;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public String getColor() {
        return color;
    }

    public int getSeatCount() {
        return seatCount;
    }

    // Static inner class for the Builder
    public static class CarBuilder {
        private String brand;
        private double engineSize;
        private String color;
        private int seatCount;

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setEngineSize(double engineSize) {
            this.engineSize = engineSize;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setSeatCount(int seatCount) {
            this.seatCount = seatCount;
            return this;
        }

        // Build method to create the Car object
        public Car build() {
            return new Car(this);
        }
    }
}