/**
 * Usman Farooqi
 * CheckersBoardTest.java
 * This program does has 3 methods
 * 1. count: this method counts the amount of black and red pieces on the board 
 * 2. move: this method will return true or false (if the given move is valid or not)
 * 3. display: this method will display a crude ASCII version of the board
 */


public class CheckersBoardTest {
	public static final int BLACK = 1;
	public static final int RED = 2;
	public static void main(String[]args){
		// This is a preset board to test all possible moves
		int [][] grid ={{2,0,2,0,2,0,2,0},
						{0,2,0,2,0,0,0,2},
						{2,0,0,0,2,0,2,0},
						{0,2,0,2,0,1,0,0},
						{1,0,0,0,0,0,0,0},
						{0,0,0,1,0,1,0,1},
						{1,0,1,0,0,0,1,0},
						{0,1,0,1,0,1,0,1}};
						
		System.out.println("This is a preset board: ");
		CheckersBoard board = new CheckersBoard(grid);
		System.out.println("");
		System.out.println("There are " + board.colourcount(BLACK) + " Black pieces");
		board.move(3,5,4,4); //checks if the given x1,y1,x2,y2 will be a valid move
	}
}