package shapes;

public class SquarePrism extends Shape
{
    private final double edgeLength;


    public SquarePrism(int height, int edgeLength) {
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
