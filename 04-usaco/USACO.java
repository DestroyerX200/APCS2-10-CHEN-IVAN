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
		int aggregatedDepth=0;
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				if (elevation - grid[i][j] > 0) {
					aggregatedDepth += elevation-grid[i][j];
				}
			}
		}
		return aggregatedDepth*72*72;
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
	public static long silver(String filename) throws FileNotFoundException {
		File f = new File(filename);
		Scanner s = new Scanner(f);
		Scanner firstLine = new Scanner(s.nextLine());
		int rows = Integer.parseInt(firstLine.next());
		int cols = Integer.parseInt(firstLine.next());
		int seconds = Integer.parseInt(firstLine.next());

		long[][] pasture = makeArraySilver(rows, cols, s);

		Scanner lastLine = new Scanner(s.nextLine());
		int rowStart = lastLine.nextInt()-1;
		int colStart = lastLine.nextInt()-1;
		int rowGoal = lastLine.nextInt()-1;
		int colGoal = lastLine.nextInt()-1;
		pasture[rowStart][colStart]=1;
		for (int i=0; i < seconds; i++) {
			pasture = iterate(pasture);
			System.out.println(Arrays.deepToString(pasture));
		}
		return pasture[rowGoal][colGoal];
	}
	private static long[][] makeArraySilver(int rows, int cols, Scanner s) {
		long[][] retArray = new long[rows][cols];
		for (int row=0; row < rows; row++) {
			String k = s.nextLine();
			for (int col=0; col < cols; col++) {
				if (k.charAt(col)=='.') {
					retArray[row][col]=0;
				}
				else {
					retArray[row][col]=-1;
				}
			}
		}
		return retArray;
	}
	private static long[][] iterate(long[][] oldPasture) {
		int rows = oldPasture.length;
		int cols = oldPasture[0].length;
		long[][] newPasture = new long[rows][cols];
		for (int r=0; r < rows; r++) {
			for (int c=0; c < cols; c++) {
				if (oldPasture[r][c]!=-1) {
					if (r > 0 && oldPasture[r-1][c]!=-1) {
						newPasture[r-1][c]+=oldPasture[r][c];
					}
					if (r < rows-1 && oldPasture[r+1][c]!=-1) {
						newPasture[r+1][c]+=oldPasture[r][c];
					}
					if (c > 0 && oldPasture[r][c-1]!=-1) {
						newPasture[r][c-1]+=oldPasture[r][c];
					}
					if (c < cols-1 && oldPasture[r][c+1]!=-1) {
						newPasture[r][c+1]+=oldPasture[r][c];
					}
				}
				else {
					newPasture[r][c]=-1;
				}
			}
		}
		return newPasture;
	}
}