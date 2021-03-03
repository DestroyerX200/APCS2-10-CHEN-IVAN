import java.util.*;
import java.io.*;
public class GenTester {
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
	public static void main(String[] args) {
		int[] counter = new int[4];
		for (int i=0; i<10000; i++) {
			int index = (int) (4*Math.random());
			counter[index]++;
		}
		char[][] test = new char[30][100];
		for (int row=0; row < 30; row++) {
			for (int col=0; col < 100; col++) {
				test[row][col]='#';
			}
		}
		MazeGenerator.generate(test, 0, 0, 3, 5);
		System.out.println(toString(test));
	}
}