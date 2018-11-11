/**
 * @(#)CheckersBoardTest.java
 *
 *
 * @author 
 * @version 1.00 2018/11/10
 */


public class CheckersBoardTest {
	public static void main(String[]args){
		// This is a preset board for the user to test all possible moves
		int [][] grid =	{{2,0,2,0,2,0,2,0},
						{0,2,0,2,0,2,0,2},
						{2,0,2,0,2,0,2,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,1,0,1,0,1,0,1},
						{1,0,1,0,1,0,1,0},
						{0,1,0,1,0,1,0,1}};
						
		CheckersBoard x = new CheckersBoard(grid);
		System.out.println(x.colourcount(2));
		System.out.println(x.colourcount(1));
		System.out.println(x.move(2,2,4,4));
	}
}