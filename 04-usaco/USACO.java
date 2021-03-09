import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class USACO {
	public static int bronze(String filename) throws FileNotFoundException{
		File f = new File(filename);
		Scanner s = new Scanner(f);
		Scanner firstLine = new Scanner(s.nextLine());
		int rows = firstLine.next();
		int cols = firstLine.next();
		int elevation = firstLine.next();
		int numInstructions = firstLine.next();

		int[][] grid = makeArrayBronze(rows, cols, s);
		return -1;
	}
	private static int[][] makeArrayBronze(int rows, int cols, Scanner s) {
		int[][] retArray = new int[rows][cols];
		for (int row=0; row < rows; row++) {
			Scanner line = new Scanner(s.nextLine());
			for (int col=0; col < cols; col++) {
				retArray[row][col]=line.nextInt();
			}
		}
		return retArray;
	}
}