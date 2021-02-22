public class QueenBoard {
	public int[][] board;

	public boolean addQueen(int r, int c) {
		if (board[r][c]==0) {
			board[r][c]--;
			return true;
		}
		return false;
	}
	public void removeQueen(int r, int c) {
		if (board[r][c]==-1) {
			board[r][c]++;
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
		return true;
	}

	/**Find all possible solutions to this size board.
	*@return the number of solutions found, and leaves the board filled with only 0's
	*@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
	*/
	public int countSolutions() {
		return 0;
	}

}