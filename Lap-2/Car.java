//Create a Builder Pattern for constructing a Car object with fields brand, engineSize, color, and seatCount.
public class Car {
    private String brand;
    private String engineSize;
    private String color;
    private int seatCount;

    private Car(CarBuilder builder) {
        this.brand = builder.brand;
        this.engineSize = builder.engineSize;
        this.color = builder.color;
        this.seatCount = builder.seatCount;
    }

    public static class CarBuilder {
        private String brand;
        private String engineSize;
        private String color;
        private int seatCount;

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setEngineSize(String engineSize) {
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

        public Car build() {
            return new Car(this);
        }
    }
}
