import java.util.*;
import java.io.*;
public class MazeGenerator {
  public static String toString(char[][] maze) {
    String retStr="";
    for (int i = 0; i < maze.length; i++) {
      
      for (int j = 0; j < maze[0].length; j++) {
        retStr+=maze[i][j];
      }
      if (i != maze.length-1) { //adding newline if not last row
      retStr += "\n";
      }
    }
    return retStr;
  }
	public static void generate(char[][]maze, int rows, int cols, int startrow, int startcol) {
		System.out.println(toString(maze));
		System.out.println();
		maze[startrow][startcol] = ' ';
		ArrayList<String> directions = possibleDirections(maze, startrow, startcol);
		while (directions.size() > 0) {
			int index = (int) (directions.size() * Math.random());
			String direction = directions.get(index);
			directions.remove(index);
			if (direction.equals("right") && checkAdjacent(maze, startrow, startcol+1)) {
				generate(maze, rows, cols, startrow, startcol+1);
			}
			else if (direction.equals("left") && checkAdjacent(maze, startrow, startcol-1)) {
				generate(maze, rows, cols, startrow, startcol-1);
			}
			else if (direction.equals("up") && checkAdjacent(maze, startrow-1, startcol)) {
				generate(maze, rows, cols, startrow-1, startcol);
			}
			else if (direction.equals("down") && checkAdjacent(maze, startrow+1, startcol)) {
				generate(maze, rows, cols, startrow+1, startcol);
			}
		}
		// int index = (int) (directions.size() * Math.random());
		// String direction="";
		// if (directions.size() > 0) {
		// 	direction = directions.get(index);
		// }
		// if (direction.equals("right")) {
		// 		generate(maze, rows, cols, startrow, startcol+1);
		// }
		// else if (direction.equals("left")) {
		// 	generate(maze, rows, cols, startrow, startcol-1);
		// }
		// else if (direction.equals("up")) {
		// 	generate(maze, rows, cols, startrow-1, startcol);
		// }
		// else if (direction.equals("down")) {
		// 	generate(maze, rows, cols, startrow+1, startcol);
		// }
		// else {
		// 	return;
		// }
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
		ArrayList<String> directions = new ArrayList<String>();
		if (row > 1 && col < maze.length-1 && checkAdjacent(maze,row-1,col)) {
			directions.add("up");
		}
		if (row < maze.length-2 && checkAdjacent(maze,row+1,col)) {
			directions.add("down");
		}
		if (col > 1 && checkAdjacent(maze,row,col-1)) {
			directions.add("left");
		}
		if (col < maze[0].length-2 && checkAdjacent(maze,row,col+1)) {
			directions.add("right");
		}
		return directions;
	}
}