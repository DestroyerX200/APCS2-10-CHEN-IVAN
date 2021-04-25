import java.util.Arrays;
public class Tester {
	public static void main(String[] args) {
		int[] test1 = {1,15,8,10,5,7,6,2,9};
		MyHeap.pushDown(test1, 9, 0);
		System.out.println(Arrays.toString(test1));
		int[] test2 = makeHeap(25, 100);
		System.out.println(Arrays.toString(test2));
		System.out.println(isHeap(test2));
		test2[0] = 12;
		MyHeap.pushDown(test2, test2.length, 0);
		System.out.println(isHeap(test2));
		System.out.println(Arrays.toString(test2));
	}
	public static int[] makeHeap(int size, int initialValue) {
		int[] data = new int[size];
		makeChildren(data, 0, initialValue);
		return data;
	}
	private static void makeChildren(int[] data, int index, int parentValue) {
		if (index < data.length) {
			data[index] = parentValue - (int) (10*Math.random())-1;
			makeChildren(data, 2*index+1, data[index]);
			makeChildren(data, 2*index+2, data[index]);
		}
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
}