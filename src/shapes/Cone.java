package shapes;

public class Cone extends Shape {
    private final double radius;

    public Cone(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return (1.0 / 3.0) * calculateBaseArea() * height;
    }

    @Override
    public double calculateBaseArea() {
        return Math.PI * radius * radius;
    }
}
