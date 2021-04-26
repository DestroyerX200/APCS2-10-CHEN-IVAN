public class MyHeap {
	private static void pushDown(int[] data, int size, int index) {
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
	private static void buildHeap(int[] data) {
		for (int i=data.length; i >= 0; i--) {
			pushDown(data, data.length, i);
		}
	}
	private static void remove(int[]data, int size) {
		swap(data, 0, size-1);
		pushDown(data, size-1, 0);
	}
	public static void heapsort(int[]data) {
		buildHeap(data);
		int size = data.length;
		for(int i=size; i>1; i--) {
			remove(data, i);
		}
	}
}