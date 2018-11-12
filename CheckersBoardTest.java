/**
 * CheckersBoardTest.java
 * Usman Farooqi
 * This program does has 3 methods
 * 1. count: this method counts the amount of black and red pieces on the board 
 * 2. move: this method will return true or false (if the given move is valid or not)
 * 3. display: this method will display an ASCII version of the board
 */


public class CheckersBoardTest {
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
		System.out.println("There are " + board.colourcount(1) + " Black pieces");
		System.out.println("There are " + board.colourcount(1) + " Red pieces");
		System.out.println("This move is " + board.move(4,2,4,6)); // checking for a double jump
	}
}