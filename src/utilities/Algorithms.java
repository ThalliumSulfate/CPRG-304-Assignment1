package utilities;

import shapes.Shape;

import java.util.Random;

public class Algorithms {
    static CompareVolume compareVolume = new CompareVolume();
    static CompareBaseArea compareBaseArea = new CompareBaseArea();


    //Thalia
    public static void quickSort(Shape[] shapes, int low, int high, char type) {
        if(low < high){
            //partitions list
            int part = partition(shapes, low, high, type);

            //sorts left list
            quickSort(shapes, low, part - 1, type);
            //sorts right list
            quickSort(shapes, part + 1, high, type);
        }
    }

    //Thalia
    private static int partition(Shape[] shapes, int low, int high, char type) {
        int comparison;
        Random rand = new Random();

        //generates random index based on the list length
        int pivotIndex = rand.nextInt(high - low) + low;
        //Puts the randomly generated pivot as the high
        swap(shapes, pivotIndex, high);

        Shape pivot = shapes[high];

        int i = low - 1;

        //compares the shapes based on selected type(in args), sorts all values lower than the pivot to the left
        switch(type) {
            case 'h': {
                for (int j = low; j < high; j++) {
                    comparison = shapes[j].compareTo(pivot);
                    if (comparison < 0) {
                        i++;
                        swap(shapes, i, j);
                    }
                }
            }
            case 'v': {
                for (int j = high; j > low; j--) {
                    comparison = compareVolume.compare(shapes[j], pivot);
                    if(comparison < 0) {
                        i++;
                        swap(shapes, i, j);
                    }
                }
            }
            case 'a': {
                for (int j = low; j < high; j++) {
                    comparison = compareBaseArea.compare(shapes[j], pivot);
                    if(comparison < 0) {
                        i++;
                        swap(shapes, i, j);
                    }
                }
            }
        }
        swap(shapes, i + 1, high);
        return i + 1;
    }

    //thalia
    private static void swap(Shape[] shapes, int i, int j){
        Shape temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }

}
