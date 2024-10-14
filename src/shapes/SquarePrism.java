package shapes;

public class SquarePrism extends Shape
{
    private final double edgeLength;


    public SquarePrism(double height, double edgeLength) {
        super(height);
        this.edgeLength = edgeLength;
    }

    public int compareTo(Shape s) {
        return super.compareTo(s);
    }

    public double calculateVolume() {
        return (calculateBaseArea()*height);
    }

    public double calculateBaseArea() {
        return edgeLength*edgeLength;
    }
}
