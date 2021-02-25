public class QueenBoard {
	private int[][] board;

	private boolean addQueen(int r, int c) {
		if (board[r][c] == 0) {
			board[r][c]--;
			for (int i=1; (c+i) < board.length; i++) {
				board[r][c+i]++;
				if (r+i < board.length) {
					board[r+i][c+i]++;
				}
				if (r-i >= 0) {
					board[r-i][c+i]++;
				}
			}
			return true;
		}
		return false;
	}
	private void removeQueen(int r, int c) {
		if (board[r][c]==-1) {
			board[r][c]++;
			for (int i=1; (c+i) < board.length; i++) {
				board[r][c+i]--;
				if (r+i < board.length) {
					board[r+i][c+i]--;
				}
				if (r-i >= 0) {
					board[r-i][c+i]--;
				}
		}
		}
	}

  public QueenBoard(int size) {
  	board = new int[size][size];
  }
  /**
	*@return The output string formatted as follows:
	*All numbers that represent queens are replaced with 'Q'
	*all others are displayed as underscores '_'
	*There are spaces between each symbol:
	*_ _ Q _
	*Q _ _ _
	*_ _ _ Q
	*_ Q _ _
	*(pythonic string notation for clarity,
	*excludes the character up to the *)
	*/
	public String toString() {
		String retStr = "";
		for (int i = 0; i < board.length; i++) {
			
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == -1) {
					retStr += "Q";
				}
				else {
					retStr += "_";
				}
				if (j != board.length-1) { //adding space if not last symbol in row
					retStr += " ";
				}
			}

			if (i != board.length-1) { //adding newline if not last row
			retStr += "\n";
			}
		}
		return retStr;
	}
	/**Find the first solution configuration possible for this size board. Start by placing
	*  the 1st queen in the top left corner, and each new queen in the next COLUMN. When backtracking
	*  move the previous queen down to the next valid space. This means everyone will generate the same
	*  first solution.
	*@return false when the board is not solveable and leaves the board filled with zeros;
	*        returns true when the board is solveable, and leaves the board in a solved state
	*@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
	*/
	public boolean solve() {
		return solve(0);
	}
	public boolean solve(int col) {
		if (col==0) {
			for (int i = 0; i < board.length; i++) { 
				for (int j = 0; j < board.length; j++) {
					if (board[i][j]!= 0) {
						throw new IllegalStateException("Invalid board state");
					}
				}
			}
		}

		for (int row=0; row<board.length;row++) {
			if (addQueen(row, col)) {
				if (col==board.length-1) {
					return true;
				}
				if (!solve(col+1)) {
					removeQueen(row, col);
				}
				else {
					return true;
				}
			}
		}
		return false;

		// if (row < board.length && col < board.length) {
		// 	if (addQueen(row, col)) {
		// 		if (col == board.length-1) {
		// 			return true;
		// 		}
		// 		else {
		// 			return solve(0, col+1);
		// 		}
		// 	}
		// 	else if (row < board.length) {
		// 		return solve(row+1, col);
		// 	}
		// 	//reached end of the column; have to backtrack
		// 	else if (col >= 1) {
		// 		int prevQueenRow=0;
		// 		while (board[prevQueenRow][col-1]!=-1) {
		// 			prevQueenRow++;
		// 		}
		// 		return solve(prevQueenRow+1, col-1);
		// 	}
		// }

		// if (row == board.length && col==0) {
		// 	return false;
		// }
		// else if (col > 0) {
		// 	int prevQueenRow=0;
		// 	while (board[prevQueenRow][col-1]!=-1) {
		// 		prevQueenRow++;
		// 	}
		// 	removeQueen(prevQueenRow, col-1);
		// 	return solve(prevQueenRow+1, col-1);
		// }
		// return false;
	}

	/**Find all possible solutions to this size board.
	*@return the number of solutions found, and leaves the board filled with only 0's
	*@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
	*/
	public int countSolutions() {
		return countSolutions(0);
	}
	public int countSolutions(int col) {
		if (col==0) {
			for (int i = 0; i < board.length; i++) { 
				for (int j = 0; j < board.length; j++) {
					if (board[i][j]!= 0) {
						throw new IllegalStateException("Invalid board state");
					}
				}
			}
		}

		int count=0;

		for (int row=0; row<board.length;row++) {
			if (addQueen(row, col)) {
				if (col == board.length-1) {
					removeQueen(row, col);
					return 1;
				}
				else {
					count+=countSolutions(col+1);
					removeQueen(row, col);
				}
			}
		}
		return count;
	}
}