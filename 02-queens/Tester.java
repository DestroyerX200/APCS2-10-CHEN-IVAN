public class Tester {
	public static void main(String[] args) {
		QueenBoard x = new QueenBoard(5);
		for (int i=0; i<5; i++) {
			x.addQueen(i, i);
			x.addQueen(4-i, i);
		}
		System.out.println(x);
		System.out.println("Function Call: x.removeQueen(2,2)");
		x.removeQueen(2,2);
		System.out.println(x);
		x.solve(0, 0);
	}
}