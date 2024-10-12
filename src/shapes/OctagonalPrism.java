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
    public int compareTo(Shape s) {
        return super.compareTo(s);
    }

    @Override
    public double calculateVolume() {
        return 8*height*edgeLength + 2*calculateBaseArea();
    }

    @Override
    public double calculateBaseArea() {
        return 2*(1 + Math.sqrt(2))*(edgeLength*edgeLength);
    }
}
