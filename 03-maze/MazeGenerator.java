import java.util.*;
import java.io.*;
public class MazeGenerator {
	public static void generate(char[][]maze, int rows, int cols, int startrow, int startcol) {
		int adjCounter = 0;
		rows = maze.length;
		cols = maze[0].length;
	}
	private static boolean checkAdjacent(char[][] maze, int row, int col) {
		if (maze[startrow+1][startcol]==' ') {
			adjCounter++;
		}
		if (maze[startrow-1][startcol]==' ') {
			adjCounter++;
		}
		if (maze[startrow][startcol+1]==' ') {
			adjCounter++;
		}
		if (maze[startrow][startcol-1]==' ') {
			adjCounter++;
		}
		return adjCounter <= 1;
	}
	private static String chooseDirection(char[][] maze, int row, int col) {
		String[] temp = {"right", "left", "up", "down"};
		ArrayList<String> directions = new ArrayList<String>(Arrays.asList(temp));
		if (row <= 1) {
			directions.remove("up");
		}
		if (row >= maze.length-2) {
			directions.remove("down");
		}
	}
}