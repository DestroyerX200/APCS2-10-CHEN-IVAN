import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
public class Tester {
	public static void main(String[] args) {
		// int[] test1 = {999,999,999,4,3,2,1,0,999,999,999};
		// System.out.println(Quick.partition(test1, 3, 7));
		// System.out.println(Arrays.toString(test1));
		// int[] test2 = {999,999,999,4,3,2,1,0,999,999,999};
		// System.out.println(Quick.partition(test2, 5, 5));
		// System.out.println(Arrays.toString(test2));
		// System.out.println(Quick.partition(test2, 6, 6));
		// System.out.println(Arrays.toString(test2));
		// System.out.println(Quick.partition(test2, 7, 7));
		// System.out.println(Arrays.toString(test2));
		// int[] test3 = {50,50,50,100,50,50,50,0,50,50,50,50,50,50};
		// System.out.println(Quick.partition(test3, 0, 13));
		// System.out.println(Arrays.toString(test3));

		// int[] test4 = {0,800,700,200,600,300,400,500,100};
		// System.out.println(Quick.quickselect(test4, 5));
		// System.out.println(Arrays.toString(test4));
		// System.out.println(Quick.quickselect(test4, 0));
		// System.out.println(Arrays.toString(test4));
		// System.out.println(Quick.quickselect(test4, 8));
		// System.out.println(Arrays.toString(test4));		

		// int[] sortedArray = generateArray(10000, 10000, 1);
		// Arrays.sort(sortedArray);
		// int[] ourArray = generateArray(10000, 10000, 1);
		// for (int i = 0; i < sortedArray.length; i++) {
		// 	System.out.println(i);
		// 	System.out.println("Correct Element : "+sortedArray[i]);
		// 	System.out.println("Your quickselect: "+Quick.quickselect(ourArray, i));
		// 	System.out.println();
		// }
		// Quick.quicksort(ourArray);
		// System.out.println(Arrays.equals(sortedArray, Quick.quicksort(ourArray)));
		if (args.length != 3) {
			System.out.println("javac Tester size type seed");
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
			Quick.quicksort(data);
			System.out.println(sorted(data));
		}
		else if (type.equals("reverse")) {
			int[] data = new int[size];
			for (int i=0; i<size; i++) {
				data[i] = size-i;
			}
			Quick.quicksort(data);
			System.out.println(sorted(data));
		}
		else if (type.equals("equal")) {
			int[] data = new int[size];
			for (int i=0; i<size; i++) {
				data[i] = 1;
			}
			Quick.quicksort(data);
			System.out.println(sorted(data));
		}
		else {
			int[] data = generateArrayRandom(size, seed);
			Quick.quicksort(data);
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