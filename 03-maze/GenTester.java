import java.util.*;
import java.io.*;
public class GenTester {
	public static void main(String[] args) {
		int[] counter = new int[4];
		for (int i=0; i<10000; i++) {
			int index = (int) (4*Math.random());
			counter[index]++;
		}
		char[][] test = new char[20][15];
		for (int row=0; row < 20; row++) {
			for (int col=0; col < 15; col++) {
				test[row][col]='#';
			}
		}
		MazeGenerator.generate(test, 0, 0, 3, 5);
		System.out.println(MazeGenerator.toString(test));
	}
}