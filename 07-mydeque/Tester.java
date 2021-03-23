import java.util.Arrays;
import java.util.NoSuchElementException;
public class Tester {
	public static void main(String[] args) {
		MyDeque<String> fruits = new MyDeque<String>(0);
		try {
			fruits.getFirst();
		} 
		catch (NoSuchElementException e) {
			System.out.println("addFirst throws correct exception for size=0!");
		}
		try {
			fruits.getLast();
		} 
		catch (NoSuchElementException e) {
			System.out.println("addLast throws correct exception for size=0!");
		}
		// System.out.println(Arrays.toString(fruits.data));
		// System.out.println(fruits);
		fruits.addFirst("apple");
		// System.out.println(Arrays.toString(fruits.data));
		// System.out.println(fruits);
		// System.out.println("start: "+fruits.start);
		// System.out.println("end: "+fruits.end);
		// System.out.println("size: "+fruits.size);
		fruits.addFirst("banana");
		// System.out.println(Arrays.toString(fruits.data));
		// System.out.println(fruits);
		// System.out.println("start: "+fruits.start);
		// System.out.println("end: "+fruits.end);
		// System.out.println("size: "+fruits.size);
		fruits.addLast("citrus");
		// System.out.println(Arrays.toString(fruits.data));
		// System.out.println(fruits);
		// System.out.println("start: "+fruits.start);
		// System.out.println("end: "+fruits.end);
		// System.out.println("size: "+fruits.size);
		fruits.addLast("durian");
		// System.out.println(Arrays.toString(fruits.data));
		// System.out.println(fruits);
		// System.out.println("start: "+fruits.start);
		// System.out.println("end: "+fruits.end);
		// System.out.println("size: "+fruits.size);
		fruits.addLast("eggplant");
		// System.out.println(Arrays.toString(fruits.data));
		// System.out.println(fruits);
		// System.out.println("start: "+fruits.start);
		// System.out.println("end: "+fruits.end);
		// System.out.println("size: "+fruits.size);

		// MyDeque<Integer> nums = new MyDeque<Integer>(10);
		// for (int i=0; i<5; i++) {
		// 	nums.addFirst(2*i);
		// 	nums.addLast(2*i+1);
		// }
		// System.out.println(Arrays.toString(nums.data));
		// System.out.println(nums);
		// System.out.println("start: "+nums.start);
		// System.out.println("end: "+nums.end);
		// System.out.println("size: "+nums.size);

		try {
			fruits.addFirst(null);
		} 
		catch (NullPointerException e) {
			System.out.println("addFirst throws correct exception for null!");
		}
		try {
			fruits.addLast(null);
		} 
		catch (NullPointerException e) {
			System.out.println("addLast throws correct exception for null!");
		}
		System.out.println(fruits);
		System.out.println(fruits.getFirst());
		System.out.println(fruits.getLast());
	}
}