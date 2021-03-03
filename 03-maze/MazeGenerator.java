import java.util.*;
import java.io.*;
public class MazeGenerator {
	public static void generate(char[][]maze, int rows, int cols, int startrow, int startcol) {
		rows = maze.length;
		cols = maze[0].length;
	}
	private static boolean checkAdjacent(char[][] maze, int row, int col) {
		int adjCounter = 0;
		if (maze[row+1][col]==' ') {
			adjCounter++;
		}
		if (maze[row-1][col]==' ') {
			adjCounter++;
		}
		if (maze[row][col+1]==' ') {
			adjCounter++;
		}
		if (maze[row][col-1]==' ') {
			adjCounter++;
		}
		return adjCounter <= 1;
	}
	private static String chooseRandomDirection(char[][] maze, int row, int col) {
		String[] temp = {"right", "left", "up", "down"};
		ArrayList<String> directions = new ArrayList<String>(Arrays.asList(temp));
		if (row <= 1 || !checkAdjacent(maze,row-1,col)) {
			directions.remove("up");
		}
		if (row >= maze.length-2 || checkAdjacent(maze,row+1,col)) {
			directions.remove("down");
		}
		if (col <= 1 || !checkAdjacent(maze,row,col-1)) {
			directions.remove("left");
		}
		if (col >= maze.length-2 || checkAdjacent(maze,row,col+1)) {
			directions.remove("right");
		}
		if (directions.size() > 0) {
			return directions.get((int) (directions.size() * Math.random()));
		}
		else {
			return "";
		}
	}
}