public class Preliminary {
	public static int partition (int[] data, int start, int end) {
		int randomIndex = start + (int) Math.random(end-start);
		swap(data, start, randomIndex);
		int pivot = data[start];

		int si = start+1;
		int ei = end;

		while (si >= ei) {
			if (data[si] < pivot) {
				si++;
			}
			else if (data[si] > pivot) {
				
			}
		}
	}
	private static void swap(int[] data, int i1, int i2) {
		int temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;
	}
}