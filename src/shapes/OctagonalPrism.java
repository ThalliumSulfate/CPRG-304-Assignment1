package shapes;

//thalia
public class OctagonalPrism extends Shape
{
    private final double edgeLength;

    public OctagonalPrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume() {
        return height*calculateBaseArea();
    }

    @Override
    public double calculateBaseArea() {
        return 2*(1 + Math.sqrt(2))*(edgeLength*edgeLength);
    }
}
