package appDomain;
import shapes.*;
import utilities.Algorithms;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppDriver {

	public static void main(String[] args) {
		// Input parameters
		String fileName = null;
		char sortType = 'v'; // Default is volume
		char algorithmType = 'b'; // Default is bubble sort

		// Parse command-line arguments
		for (int i = 0; i < args.length; i++) {
			String arg = args[i].toLowerCase();
			if (arg.startsWith("-f")) {
				fileName = arg.substring(2);
			} else if (arg.startsWith("-t")) {
				sortType = arg.charAt(2);
			} else if (arg.startsWith("-s")) {
				algorithmType = arg.charAt(2);
			}
		}

		// Validate input
		if (fileName == null) {
			System.out.println("Error: No input file provided. Use -f option to specify the file name.");
			return;
		}

		// parsing shapes from file
		Shape[] shapes;
		try {
			shapes = readShapesFromFile(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found: " + fileName);
			return;
		}

		// Perform sorting based on selected algorithm
		long startTime = System.currentTimeMillis();
		switch (algorithmType) {
			case 'b':
				System.out.println("Using Bubble Sort...");
				Algorithms.bubbleSort(shapes, sortType);
				break;
			case 'i':
				System.out.println("Using Insertion Sort...");
				Algorithms.insertionSort(shapes, sortType);
				break;
			case 's':
				System.out.println("Using Selection Sort...");
				Algorithms.selectionSort(shapes, sortType);
				break;
			case 'm':
				System.out.println("Using Merge Sort...");
				Algorithms.mergeSort(shapes, 0, shapes.length - 1, sortType);
				break;
			case 'q':
				System.out.println("Using Quick Sort...");
				Algorithms.quickSort(shapes, 0, shapes.length - 1, sortType);
				break;
			case 'z': // Custom sort (e.g., Counting Sort for Volume)
				System.out.println("Using Custom Sorting Algorithm (Counting Sort)...");
				Algorithms.countingSort(shapes, sortType);
				break;
			default:
				System.out.println("Error: Invalid sorting algorithm. Use -sb, -si, -ss, -sm, -sq, or -sz.");
				return;
		}
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;

		// Output sorted result benchmarks
		printSortedResults(shapes, sortType);
		System.out.println("Sorting run time was: " + elapsedTime + " milliseconds");
	}

	// Method to read shapes from file
	private static Shape[] readShapesFromFile(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		int numberOfShapes = scanner.nextInt();
		Shape[] shapes = new Shape[numberOfShapes];

		for (int i = 0; i < numberOfShapes; i++) {
			String shapeType = scanner.next();
			double height = scanner.nextDouble();
			double parameter = scanner.nextDouble();

			switch (shapeType.toLowerCase()) {
				case "cylinder":
					shapes[i] = new Cylinder(height, parameter);
					break;
				case "cone":
					shapes[i] = new Cone(height, parameter);
					break;
				case "pyramid":
					shapes[i] = new Pyramid(parameter, height);
					break;
				case "squareprism":
					shapes[i] = new SquarePrism(height, parameter);
					break;
				case "triangularprism":
					shapes[i] = new TriangularPrism(height, parameter);
					break;
				case "pentagonalprism":
					shapes[i] = new PentagonalPrism(height, parameter);
					break;
				case "octagonalprism":
					shapes[i] = new OctagonalPrism(height, parameter);
					break;
				default:
					System.out.println("Error: Unknown shape type in file: " + shapeType);
					return new Shape[0];
			}
		}
		scanner.close();
		return shapes;
	}

	// Method to print the sorted shapes results
	private static void printSortedResults(Shape[] shapes, char sortType) {
		int length = shapes.length;
		String criteria = getCriteriaDescription(sortType);

		// Print first element
		System.out.println("First element is: " + getShapeDescription(shapes[0], sortType, criteria));

		// Iterate and print every thousandth element, if applicable
		for (int i = 1000; i < length; i += 1000) {
			if (i < length) {
				System.out.println(i + "-th element is: " + getShapeDescription(shapes[i], sortType, criteria));
			}
		}

		// Print the second last element
		if (length > 1) {
			System.out.println("Second Last element is: " + getShapeDescription(shapes[length - 2], sortType, criteria));
		}

		// Print the last element
		System.out.println("Last element is: " + getShapeDescription(shapes[length - 1], sortType, criteria));
	}

	// Helper method to get criteria description (volume, height, base area)
	private static String getCriteriaDescription(char sortType) {
		switch (sortType) {
			case 'h':
				return "Height";
			case 'v':
				return "Volume";
			case 'a':
				return "Base Area";
			default:
				return "Unknown Criteria";
		}
	}

	// Helper method
	private static String getShapeDescription(Shape shape, char sortType, String criteria) {
		String value = "";
		switch (sortType) {
			case 'h':
				value = String.format("%.2f", shape.getHeight());
				break;
			case 'v':
				value = String.format("%.2f", shape.calculateVolume());
				break;
			case 'a':
				value = String.format("%.2f", shape.calculateBaseArea());
				break;
		}
		return shape.getClass().getSimpleName() + " with a " + criteria + " of: " + value;
	}
}
