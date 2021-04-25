public class MyHeap {
	public static void pushDown(int[] data, int size, int index) {
		if (2*index+1 < size) {
			int childIndex = 2*index+1;
			int maxChild = data[2*index+1];
			if (2*index+2 < size && maxChild < data[2*index+2]) {
				childIndex++;
				maxChild = data[childIndex];
			}
			if (maxChild > data[index]) {
				swap(data, index, childIndex);
				pushDown(data, size, childIndex);
			}
		}
	}
	private static void swap(int[] data, int i1, int i2) {
		int temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;
	}
}