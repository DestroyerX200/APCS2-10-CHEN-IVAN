import java.util.Arrays;
public class Tester {
	public static void main(String[] args) {
		// int[] test1 = {999,999,999,4,3,2,1,0,999,999,999};
		// System.out.println(Quick.partition(test1, 3, 7));
		// System.out.println(Arrays.toString(test1));
		// int[] test2 = {999,999,999,4,3,2,1,0,999,999,999};
		// System.out.println(Quick.partition(test2, 5, 5));
		// System.out.println(Arrays.toString(test2));
		// int[] test3 = {50,50,50,100,50,50,50,0,50,50,50,50,50,50};
		// System.out.println(Quick.partition(test3, 0, 13));
		// System.out.println(Arrays.toString(test3));

		int[] test4 = {0,800,700,200,600,300,400,500,100};
		System.out.println(Quick.quickselect(test4, 5));
		System.out.println(Arrays.toString(test4));
	}
}