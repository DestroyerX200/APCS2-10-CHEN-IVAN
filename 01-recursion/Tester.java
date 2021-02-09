public class Tester {
	public static void main(String[] args) {
		String a = "woc";
		System.out.println(Recursion.reverse(a) );
		System.out.println(Recursion.countNoDoubleLetterWords(3, "")); //should return 26*25*25 = 16250
		System.out.println(Recursion.countNoDoubleLetterWords(0, "")); // 1
		System.out.println(Recursion.countNoDoubleLetterWords(1, "")); // 26
		System.out.println(Recursion.countNoDoubleLetterWords(2, "")); // 26*25= 650
		System.out.println(Recursion.sqrt(1000000)); // ~1000
		System.out.println(Recursion.sqrt(1.0 / 3.0)); // ~0.577
	}
}