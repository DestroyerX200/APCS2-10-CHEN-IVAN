import java.util.*;
import java.io.*;
public class Maze {

  private char[][]maze;
  private boolean animate; //false by default

  /*Constructor loads a maze text file, and sets animate to false by default.
    When the file is not found then:
       throw a FileNotFoundException

    You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
    '#' - Walls - locations that cannot be moved onto
    ' ' - Empty Space - locations that can be moved onto
    'E' - the location of the goal (exactly 1 per file)
    'S' - the location of the start(exactly 1 per file)

    You may also assume the maze has a border of '#' around the edges.
    So you don't have to check for out of bounds!
  */
  public Maze(String filename) throws FileNotFoundException {
    animate = false;
    File f = new File(filename);
    Scanner s = new Scanner(f);

    int numRows=1;
    int numCols=s.nextLine().length();
    
    while (s.hasNextLine()) {
      numRows++;
      s.nextLine();
    }
    Scanner newS = new Scanner(f);
    maze = new char[numRows][numCols];
    
    for (int row=0; row < numRows; row++) {
      String line = newS.nextLine();
      for (int col=0; col < numCols; col++) {
        maze[row][col] = line.charAt(col);
      }
    }
  }

  private void wait(int millis) {
       try {
           Thread.sleep(millis);
       }
       catch (InterruptedException e) {
       }
   }

  public void setAnimate(boolean b) {
      animate = b;
  }

  public static void clearTerminal() {
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop() {
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
   It should look like the text file with some characters replaced.
  */
  public String toString() {
    String retStr="";
    for (int i = 0; i < maze.length; i++) {
      
      for (int j = 0; j < maze[0].length; j++) {
        retStr+=maze[i][j];
      }
      if (i != maze.length-1) { //adding newline if not last row
      retStr += "\n";
      }
    }
    return retStr;
  }

  /*Wrapper Solve Function returns the helper function
    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve() {
    //only clear the terminal if you are running animation
    if(animate){
      clearTerminal();
    }
    for (int row=0; row < maze.length; row++) {
      for (int col=0; col < maze[0].length; col++) {
        if (maze[row][col] == 'S') {
          return solve(row, col, 0);
        }
      }
    }
    return -1;
  }

  /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.

    Postcondition:
      The 'S' is replaced with '@'
      The 'E' remain the same
      All visited spots that were not part of the solution are changed to '.'
      All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col, int steps) { //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
        gotoTop();
        System.out.println(this);
        wait(50);
    }
    if (maze[row][col] == 'E') {
      return steps;
    }
    maze[row][col] = '@';
    if (maze[row][col+1] == ' ' || maze[row][col+1] == 'E') {
      return solve(row, col+1, steps+1);
    }
    else if (maze[row][col-1] == ' ' || maze[row][col-1] == 'E') {
      return solve(row, col-1, steps+1);
    }
    else if (maze[row+1][col] == ' ' || maze[row+1][col] == 'E') {
      return solve(row+1, col, steps+1);
    }
    else if (maze[row-1][col] == ' ' || maze[row-1][col] == 'E') {
      return solve(row-1, col, steps+1);
    }
    else {
      maze[row][col] = '.';
      if (maze[row][col+1] == '@') {
        return solve(row, col+1, steps-1);
    }
      else if (maze[row][col-1] == '@') {
        return solve(row, col-1, steps-1);
      }
      else if (maze[row+1][col] == '@') {
        return solve(row+1, col, steps-1);
      }
      else if (maze[row-1][col] == '@') {
        return solve(row-1, col, steps-1);
      }
      else {
        return -1;
      }
    }
  }
}
