import java.util.*;
import java.io.*;
public class Tester {
	public static void main(String[] args) {
		Maze f;
		String filename = args[0];
		try {
			f = new Maze(filename);
			// System.out.println(Arrays.deepToString(f.maze));
			// System.out.println(f);
			f.setAnimate(true);
			System.out.println(f.solve());
			System.out.println(f);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: "+filename);
			System.exit(1);
		}
	}
}