import java.util.Arrays;
public class Tester {
	public static void main(String[] args) {
		int[] test1 = {999,999,999,4,3,2,1,0,999,999,999};
		System.out.println(Preliminary.partition(test1, 3, 7));
		System.out.println(Arrays.toString(test1));
		int[] test2 = {999,999,999,4,3,2,1,0,999,999,999};
		System.out.println(Preliminary.partition(test2, 5, 5));
		System.out.println(Arrays.toString(test2));
	}
}