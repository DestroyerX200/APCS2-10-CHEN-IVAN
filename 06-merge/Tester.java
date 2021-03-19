import java.util.Arrays;
public class Tester {
	public static void main(String[] args) {
		int[] source = {1,2,6,9,10,3,5,8,9};
		int[] dest = {1,2,6,9,10,3,5,8,9};
		Merge.merge(source, dest, 0, 4, 8);
		System.out.println(Arrays.toString(dest));
	}
}