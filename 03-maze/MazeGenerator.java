import java.util.*;
import java.io.*;
public class MazeGenerator {
	private boolean animate = false;
	public static void generate(char[][]maze, int rows, int cols, int startrow, int startcol) {
		maze[startrow][startcol] = ' ';
		ArrayList<String> directions = possibleDirections(maze, startrow, startcol);
		while (directions.size() > 0) {
			int index = (int) (directions.size() * Math.random());
			String direction = directions.get(index);
			directions.remove(index);
			if (direction.equals("right")) {
				generate(maze, rows, cols, startrow, startcol+1);
			}
			else if (direction.equals("left")) {
				generate(maze, rows, cols, startrow, startcol-1);
			}
			else if (direction.equals("up")) {
				generate(maze, rows, cols, startrow-1, startcol);
			}
			else if (direction.equals("down")) {
				generate(maze, rows, cols, startrow+1, startcol);
			}
		}
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
	private static ArrayList<String> possibleDirections(char[][] maze, int row, int col) {
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
		return directions;
	}
}