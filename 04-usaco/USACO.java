import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class USACO {
	public static int bronze(String filename) throws FileNotFoundException {
		File f = new File(filename);
		Scanner s = new Scanner(f);
		Scanner firstLine = new Scanner(s.nextLine());
		int rows = Integer.parseInt(firstLine.next());
		int cols = Integer.parseInt(firstLine.next());
		int elevation = Integer.parseInt(firstLine.next());
		int numInstructions = Integer.parseInt(firstLine.next());

		int[][] grid = makeArrayBronze(rows, cols, s);
		for (int i=0; i<numInstructions; i++) {
			Scanner line = new Scanner(s.nextLine());
			int r_s = line.nextInt()-1;
			int c_s = line.nextInt()-1;
			int d_s = line.nextInt();
			stomp(grid, r_s, c_s, d_s);
		}
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
	private static void stomp(int[][] grid, int row, int col, int d_s) {
		int maxElevation = 0;
		for (int r=row; r <= row+2; r++) {
			for (int c=col; c <= col+2; c++) {
				if (grid[r][c] > maxElevation) {
					maxElevation=grid[r][c];
				}
			}
		}
		int upperBound = maxElevation-d_s;
		for (int r=row; r <= row+2; r++) {
			for (int c=col; c <= col+2; c++) {
				if (grid[r][c] > upperBound) {
					grid[r][c] = upperBound;
				}
			}
		}
	}
}