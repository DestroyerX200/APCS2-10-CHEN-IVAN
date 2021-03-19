import java.util.Arrays;
public class Merge {
	public static void mergesort(int[] data) {
		mergesort(data, 0, data.length-1);
	}
	public static void mergesort(int[] data, int lo, int hi) {
		int[] temp = new int[data.length];
		for (int i=0; i<data.length; i++) {
			temp[i] = data[i];
		}
		mergesort(data, temp, lo, hi);
	}
	public static void mergesort(int[] data, int[] temp, int lo, int hi) {
		if (hi > lo) {
			int mid = (lo+hi)/2;
			mergesort(temp, data, lo, mid);
			mergesort(temp, data, mid+1, hi);
			merge(temp, data, lo, mid, hi);
		}
	}
	public static void merge(int[] source, int[] dest, int start, int middle, int end) {
		int i = start;
		int j = middle+1;
		int k = start;
		while (i <= middle && j <= end) {
			if (source[i] < source[j]) {
				dest[k] = source[i];
				i++;
			}
			else {
				dest[k] = source[j];
				j++;
			}
			k++;
		}
		if (i <= middle) {
			for (;i <= middle; i++) {
				dest[k] = source[i];
				k++;
			}
		}
		else {
			for (;j <= end; j++) {
				dest[k] = source[j];
				k++;
			}
		}
	}
}