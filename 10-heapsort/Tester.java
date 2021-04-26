import java.util.Arrays;
public class Tester {
	public static void main(String[] args) {
		// int size = 10000;
		// double numTests = 1000;
		// double passedTests=0;
		// for (double i=0; i < numTests; i++) {
		// 	int[] test = makeArray(size);
		// 	MyHeap.buildHeap(test);
		// 	if (isHeap(test)) {
		// 		passedTests++;
		// 	}
		// }
		// System.out.println(100*numTests/passedTests + "% of tests passed!");

		int[] testSort1 = makeArray(20);
		System.out.println(Arrays.toString(testSort1));
		MyHeap.heapsort(testSort1);
		System.out.println(Arrays.toString(testSort1));

	}
	public static boolean isHeap(int[] data) {
		for (int i=0; i<data.length; i++) {
			if (2*i+1 < data.length && data[2*i+1] > data[i]) {
				return false;
			}
			if (2*i+2 < data.length && data[2*i+2] > data[i]) {
				return false;
			}
		}
		return true;
	}
	public static int[] makeArray(int size) {
		int[] retArray = new int[size];
		for(int i=0; i<size; i++) {
			retArray[i] = (int) (10000*Math.random());
		}
		return retArray;
	}
}