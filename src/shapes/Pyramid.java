package shapes;

// Kourosh (Amir)

public class Pyramid extends Shape {
    private final double side;

    // GETTER
    public Pyramid(double side, double height) {
        super(height);
        this.side = side;
    }

    @Override
    public int compareTo(Shape other) {
        if (other instanceof Pyramid) {
            Pyramid otherPyramid = (Pyramid) other;
            return Double.compare(this.calculateVolume(), otherPyramid.calculateVolume());
        }
        return 0; // Or handle other cases as needed
    }

    // RETURN VOLUME

    @Override
    public double calculateVolume() {
        // Volume of a pyramid = (1/3) * base area * height
        return (1.0 / 3.0) * calculateBaseArea() * height;
    }

    // Return Area
    @Override
    public double calculateBaseArea() {
        // Base area of a pyramid with a square base = side^2
        return side * side;
    }
}
