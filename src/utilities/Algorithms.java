package utilities;

import shapes.Shape;

import java.util.Arrays;
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
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        //Puts the randomly generated pivot as the high
        swap(shapes, pivotIndex, high);

        Shape pivot = shapes[high];

        int i = low - 1;

        //compares the shapes based on selected type(in args), sorts all values lower than the pivot to the left
        for (int j = low; j < high; j++) {
            if(shouldSwap(shapes[j], pivot, type)) {
                i++;
                swap(shapes, i, j);
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

    // Kourosh (Amir)
    // Bubble Sorting
    public static void bubbleSort(Shape[] shapes, char type) {
        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (!shouldSwap(shapes[j], shapes[j + 1], type)) {
                    swap(shapes, j, j + 1);
                }
            }
        }
    }

    private static boolean shouldSwap(Shape s1, Shape s2, char type) {
        int comparison = compareShapes(s1, s2, type);
        return comparison > 0;
    }


    // Kourosh (Amir)
    //Insertion
    public static void insertionSort(Shape[] shapes, char type) {
        for (int i = 1; i < shapes.length; i++) {
            Shape key = shapes[i];
            int j = i - 1;

            while (j >= 0 && !shouldSwap(shapes[j], key, type)) {
                shapes[j + 1] = shapes[j];
                j = j - 1;
            }
            shapes[j + 1] = key;
        }
    }

    private static int compareShapes(Shape s1, Shape s2, char type) {
        switch (type) {
            case 'h':
                return s1.compareTo(s2);
            case 'v':
                return compareVolume.compare(s1, s2);
            case 'a':
                return compareBaseArea.compare(s1, s2);
            default:
                throw new IllegalArgumentException("Invalid");
        }
    }


    // Kourosh (Amir)
    //Selection
    public static void selectionSort(Shape[] shapes, char type) {
        for (int i = 0; i < shapes.length - 1; i++) {
            int maxIndex = i;  // Assume the min is the first element
            for (int j = i + 1; j < shapes.length; j++) {
                if (compareShapes(shapes[j], shapes[maxIndex], type) > 0) {
                    maxIndex = j;  // Found new minimum; remember its index
                }
            }
            if (maxIndex != i) {
                swap(shapes, i, maxIndex);  // Swap if new minimum is found
            }
        }
    }


    // Kourosh (Amir)
// Merge Sort
    public static void mergeSort(Shape[] shapes, int low, int high, char type) {
        if (low < high) {
            //  middle point
            int middle = (low + high) / 2;


            mergeSort(shapes, low, middle, type);
            mergeSort(shapes, middle + 1, high, type);

            // Mergeing
            merge(shapes, low, middle, high, type);
        }
    }

    private static void merge(Shape[] shapes, int low, int middle, int high, char type) {

        int n1 = middle - low + 1;
        int n2 = high - middle;


        Shape[] leftArray = new Shape[n1];
        Shape[] rightArray = new Shape[n2];


        System.arraycopy(shapes, low, leftArray, 0, n1);
        System.arraycopy(shapes, middle + 1, rightArray, 0, n2);



        int i = 0, j = 0;
        int k = low;
        while (i < n1 && j < n2) {
            if (compareShapes(leftArray[i], rightArray[j], type) > 0) {
                shapes[k] = leftArray[i];
                i++;
            } else {
                shapes[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            shapes[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            shapes[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Kourosh (Amir)
    // counting  Sort


    // Counting Sort for Shape objects input(cannot work)
    /*public static void countingSort(Shape[] shapes, char type) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (Shape shape : shapes) {
            int key = extractKey(shape, type);
            if (key > max) {
                max = key;
            }
            if (key < min) {
                min = key;
            }
        }

        //handle negatives
        int offset = min < 0 ? -min : 0;
        int range = max + offset + 1;

        // Initialize count array with the size of max + 1
        int[] count = new int[range];
        Arrays.fill(count, 0);

        // Store the count of each element
        for (Shape shape : shapes) {
            int key = extractKey(shape, type);
            count[key + offset]++;
        }

        // Change count so that positions in the final output can be determined
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // Build the output array
        Shape[] output = new Shape[shapes.length];
        for (int i = shapes.length - 1; i >= 0; i--) {
            int key = extractKey(shapes[i], type);
            output[count[key + offset] - 1] = shapes[i];
            count[key + offset]--;
        }

        // Copy the sorted elements back to the original array
        System.arraycopy(output, 0, shapes, 0, shapes.length);
    }

    private static int extractKey(Shape shape, char type) {
        int key;
        switch (type) {
            case 'h':
                key = (int) shape.getHeight();
                break;
            case 'v': // Sorting by volume
                System.out.println(shape.calculateVolume());
                key = (int) shape.calculateVolume(); // Casting volume to int
                break;
            case 'a': // Sorting by base area
                key = (int) shape.calculateBaseArea(); // Casting base area to int
                break;
            default:
                throw new IllegalArgumentException("Unsupported type " + type);
        }

        System.out.println("Shape: " + shape + ", Key: " + key);

        return key;
    }*/
}
