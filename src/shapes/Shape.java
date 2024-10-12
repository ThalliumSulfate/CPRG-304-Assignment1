package shapes;

//thalia
public abstract class Shape implements Comparable<Shape> {
    protected final double height;

    public double getHeight() {
        return height;
    }

    public Shape(double height) {
        this.height = height;
    }

    public int compareTo(Shape s) {
        if(this.height == s.getHeight()) {
            return 0;
        }
        else if(this.height < s.getHeight()) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public abstract double calculateVolume();
    public abstract double calculateBaseArea();
}
