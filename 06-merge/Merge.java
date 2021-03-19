public class Merge {
	public static void mergesort(int[] data) {
		System.out.println("CODE THIS");
	}
	public static void merge(int[] source, int[] dest, int sStart, int sEnd, int dStart, int dEnd) {
		int si = sStart;
		int di = dStart;
		int i=sStart;
		while (si < sEnd && di < dEnd) {
			if (source[si] < dest[di]) {
				dest[i] = source[si];
				si++;
				i++;
			}
			else {
				dest[i] = dest[di];
				di++;
				i++;
			}
		}
		if (si < sEnd) {
			for (si; si<sEnd; si++) {
				dest[i] = source[si];
				i++;
			}
		}
		else {
			for (di; di<dEnd; di++) {
				dest[i] = dest[di];
				i++;
			}
		}
}