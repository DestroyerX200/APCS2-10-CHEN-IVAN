import java.util.*;
import java.io.*;
public class Tester {
	public static void main(String[] args) {
		Maze f;
		String filename = args[0];
		try {
			f = new Maze(filename);
			System.out.println(Arrays.deepToString(f.maze));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: "+filename);
			System.exit(1);
		}
	}
}