package shapes;

//thalia
public class SquarePrism extends Shape
{
    private final double edgeLength;


    public SquarePrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    @Override
    public double calculateVolume() {
        return (calculateBaseArea()*height);
    }

    @Override
    public double calculateBaseArea() {
        return edgeLength*edgeLength;
    }
}
