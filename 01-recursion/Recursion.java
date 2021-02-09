public class Recursion {
	public static String reverse(String s) {
		if (s.length() <= 1) {
			return s;
		}
		else {
			return reverse(s.substring(1)) + s.charAt(0);
		}
	}
	public static long countNoDoubleLetterWords(int length, String word) {
		long sum = 0;
		if (length == 0) {
			return 1;
		}
		char[] alphabet = new char[26];
		for (char i = 'a'; i <= 'z'; i++) {
			alphabet[i-'a'] = i;
		}
		for (int i = 0; i < 26; i++) {
			char letter = alphabet[i];
			if (word.length() == 0 || word.charAt(word.length()-1) != letter) {
				sum += countNoDoubleLetterWords(length-1, word + letter);
			}
		}
		return sum;
	}
	public static double sqrt(double n) {
		return sqrt(n, n/2, 0.001);
	}
	public static double sqrt(double n, double guess, double percentAccuracy) {
		if (Math.abs(guess * guess - n) <= n * percentAccuracy / 100) {
			return guess;
		}
		else {
			return sqrt(n, (guess + n / guess) / 2, percentAccuracy);
		}
	}
}