import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class Tester {
	public static void main(String[] args) {
		String filename = args[0];
		try {
			System.out.println(USACO.bronze(filename));
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
			System.exit(1);
		}
	}
}