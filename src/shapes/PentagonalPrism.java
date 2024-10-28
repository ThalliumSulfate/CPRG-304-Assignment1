package shapes;

public class PentagonalPrism extends Shape {
    private final double edgeLength;

    public PentagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume() {
        return calculateBaseArea() * height;
    }

    @Override
    public double calculateBaseArea() {
        return (5 * edgeLength * edgeLength * Math.tan(Math.toRadians(54))) / 4;
    }
}
