import java.util.*;
import java.io.*;
public class GenTester {
	public static void main(String[] args) {
		int[] counter = new int[4];
		for (int i=0; i<10000; i++) {
			int index = (int) (4*Math.random());
			counter[index]++;
		}
		System.out.println(Arrays.toString(counter));
	}
}