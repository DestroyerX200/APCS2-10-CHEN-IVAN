import java.util.Arrays;
public class Tester {
	public static void main(String[] args) {
		int[] test1 = {1,15,8,10,5,7,6,2,9};
		MyHeap.pushDown(test1, 9, 0);
		System.out.println(Arrays.toString(test1));
		int[] unsortedArray1 = {1, 3, 2, 4, 6, 5, 10, 9, 8};
		System.out.println(isHeap(unsortedArray1));
    MyHeap.buildHeap(unsortedArray1);
		System.out.println(isHeap(unsortedArray1));
		System.out.println(Arrays.toString(unsortedArray1));
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