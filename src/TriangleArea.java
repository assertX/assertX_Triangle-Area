package assignment_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TriangleArea {
	public static void main(String[] args) throws IOException {
		// Open input/output files and create scanners.
		FileInputStream inputFile = new FileInputStream("triangles.txt");
		Scanner scanner = new Scanner(inputFile);
		FileOutputStream outputFile = new FileOutputStream("areas.txt");
		PrintWriter writer = new PrintWriter(outputFile);
		
		
		// Loop through the input file to retrieve data, calculate, then write to output file.
		while (scanner.hasNextDouble()) {
			// Reads each line and will assign the side values.
			double sideA = scanner.nextDouble(), sideB = scanner.nextDouble(), sideC = scanner.nextDouble();
			

			if ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA)){
				double halfPerimeter = ((sideA + sideB + sideC) / 2);
				double totalArea = Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
				writer.printf("%.2f\n", totalArea);
				
			} else {
				writer.println("Invalid triangle");
			}
		
		}

		// Close input, output, and all scanners.
		writer.close();
		outputFile.close();
		scanner.close();
		inputFile.close();
	}
}
