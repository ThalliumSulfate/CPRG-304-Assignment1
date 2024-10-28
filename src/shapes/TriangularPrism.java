package shapes;

public class TriangularPrism extends Shape {
    private final double edgeLength;

    public TriangularPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume() {
        return calculateBaseArea() * height;
    }

    @Override
    public double calculateBaseArea() {
        return (Math.sqrt(3) / 4) * edgeLength * edgeLength;
    }
}
