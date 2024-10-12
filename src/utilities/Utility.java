package utilities;

import shapes.Shape;

import java.util.Comparator;

//thalia
class CompareVolume implements Comparator<Shape> {

    @Override
    public int compare(Shape s1, Shape s2) {
        if(s1.calculateVolume() == s2.calculateVolume()) {
            return  0;
        }
        else if(s1.calculateVolume() < s2.calculateVolume()) {
            return  -1;
        }
        else {
            return  1;
        }
    }
}

//thalia
class CompareBaseArea implements Comparator<Shape> {
    @Override
    public int compare(Shape s1, Shape s2) {
        if(s1.calculateBaseArea() == s2.calculateBaseArea()) {
            return  0;
        }
        else if(s1.calculateBaseArea() < s2.calculateBaseArea()) {
            return  -1;
        }
        else {
            return  1;
        }
    }
}
