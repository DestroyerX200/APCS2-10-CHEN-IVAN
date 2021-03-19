public class Merge {
	public static void mergesort(int[] data) {
		System.out.println("CODE THIS");
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