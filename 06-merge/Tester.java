import java.util.Arrays;
import java.util.Random;
public class Tester {
	public static void main(String[] args) {
		// int[] source = {1,2,6,9,10,3,5,8,9};
		// int[] dest = {1,2,6,9,10,3,5,8,9};
		// Merge.merge(source, dest, 0, 4, 8);
		// System.out.println(Arrays.toString(dest));
		// Merge.mergesort(source);
		// System.out.println(Arrays.toString(source));
		// int[] test1 = {9,8,7,6,5,4,3,2,1,0};
		// Merge.mergesort(test1);
		// System.out.println(Arrays.toString(test1));

		if (args.length != 3) {
			System.out.println("java Tester size type seed");
			System.out.println("types: random, sorted, reverse, equal");
		}
		int size = Integer.parseInt(args[0]);
		String type = args[1];
		int seed = Integer.parseInt(args[2]);
		
		if (type.equals("sorted")) {
			int[] data = new int[size];
			for (int i=0; i<size; i++) {
				data[i] = i;
			}
			Merge.mergesort(data);
			System.out.println(sorted(data));
		}
		else if (type.equals("reverse")) {
			int[] data = new int[size];
			for (int i=0; i<size; i++) {
				data[i] = size-i;
			}
			Merge.mergesort(data);
			System.out.println(sorted(data));
		}
		else if (type.equals("equal")) {
			int[] data = new int[size];
			for (int i=0; i<size; i++) {
				data[i] = 1;
			}
			Merge.mergesort(data);
			System.out.println(sorted(data));
		}
		else {
			int[] data = generateArrayRandom(size, seed);
			Merge.mergesort(data);
			System.out.println(sorted(data));
		}
	}
	public static int[] generateArrayRandom(int sizeOfArray, int seed) {
		int[] retArray = new int[sizeOfArray];
		Random rng = new Random(seed);
		for (int i=0; i<sizeOfArray; i++) {
			retArray[i] = rng.nextInt() % 10000;
		}
		return retArray;
	}
	public static boolean sorted(int[] data) {
		for (int i=0; i < data.length-1; i++) {
			if (data[i] > data[i+1]) {
				return false;
			}
		}
		return true;
	}	
}