package shapes;

public class Cylinder extends Shape
{
    private final double radius;

    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double calculateVolume() {
        return (calculateBaseArea() * height);
    }

    @Override
    public double calculateBaseArea() {
        return (Math.PI * (radius * radius));
    }
}
