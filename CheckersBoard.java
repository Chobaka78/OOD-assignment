

import java.util.*;
public class CheckersBoard {
	
	public static final int BLACK = 1;
	public static final int RED = 2;
	public int [][] grid;
								  
	public CheckersBoard(int[][] grid){ //  This is the constructor
	    this.grid = grid;
	    this.display();
	}
	
	public int colourcount(int colour){
		// count method that goes through the board and counts the number of pieces for the colour given
		int colourcounter = 0;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(grid[i][j] == colour){
					colourcounter += 1;
				}
			}
		}
		return colourcounter;
	}
	
	public void move(int x1, int y1, int x2, int y2){ // move method will return true or false (if move is valid)
		if (x1 < 0 || x1 >7 || y1 < 0 || y1 > 7 || x2 < 0 || x2 >7 || y2 < 0 || y2 > 7){
			System.out.println("This is not a valid move (False)");
			System.out.println("");
		}
		else if (Math.abs(x1-x2) == 1 && Math.abs(y1 - y2) == 1){
			if(grid[y1][x1] == BLACK){ // checks for all black peices
			
				if (x1 > 0 && grid[y1 - 1][x1 - 1] == 0){ // move 1 up and 1 to the left
					grid[y1-1][x1-1] = BLACK; // set the moved piece to black
					grid[y1][x1] = 0; // set original piece to blank
				}
				else if(grid[y1 - 1][x1 + 1] == 0){ // move 1 up and 1 to the right
					grid[y1-1][x1+1] = BLACK; // set the move piece to black
					grid[y1][x1] = 0;// set the original piece to blank
				}
				
			}
			
			else if(grid[y1][x1] == RED){ // checking for all red pieces 
			
				if (grid[y1 + 1][x1 - 1] == 0){ // move 1 up and 1 to the left
					grid[y1+1][x1-1] = RED; // set moved to red
					grid[y1][x1] = 0; // set original to blank
				}
				else if(grid[y1 + 1][x1 + 1] == 0){  // move 1 up and 1 to the right
					grid[y1+1][x1+1] = RED; // set moved to red
					grid[y1][x1] = 0; // set original to blank
				}
			}
		}
		
		else if(Math.abs(x1-x2) != 1 && (Math.abs(y1 - y2) != 1)){
			if(grid[y1][x1] == BLACK){ // checks all black pieces
				
				if(x1 > 0 && grid[y1-1][x1-1] == RED && grid[y1-2][x1-2] == 0){ // if there is a red piece that can be captured followed by empty spot (left side)
					grid[y1-1][x1-1] = 0; // set captured piece to empty
					grid[y1-2][x1-2] = BLACK; // set moved to black
					grid[y1][x1] = 0; // set original to blank
				}
				else if(x1 < 7 && grid[y1-1][x1+1] == RED && grid[y1-2][x1+2] == 0){ // if there is a red piece that can be captured followed by empty spot (right side)
					grid[y1-1][x1+1] = 0;  // set captured to empty
					grid[y1-2][x1+2] = BLACK; // set moved to black 
					grid[y1][x1] = 0; // set original to empty
				}
				else if ( x1 > 0 && grid[y1-1][x1-1]== RED && grid[y1-2][x1-2] == 0 && grid[y1-3][x1-1] == RED && grid[y1-4][x1] == 0){ // if double jump is possible (left side)
				// for double jump to be possible (there has to be a piece that can be captured followed by empty spot followed by another piece and empty spot
					grid[y1-1][x1-1] = 0; // set the first captrued piece to empty 
					grid[y1-3][x1-2] = 0; // set the second captured piece to empty 
					grid[y1-4][x1] = BLACK; // set moved to black
					grid[y1][x1] = 0; // set original to empty
				}
				else if ( x1 < 7 && grid[y1-1][x1+1]== RED && grid[y1-2][x1+2] == 0 && grid[y1-3][x1+1] == RED && grid[y1-4][x1] == 0){ // if double jump is possilbe (right side)
					grid[y1-1][x1+1] = 0; // set the first captured piece to empty 
					grid[y1-3][x1+2] = 0; // set the second captured piece to empty 
					grid[y1-4][x1] = BLACK; // set moved to black
					grid[y1][x1] = 0; // set original to empty
				}
			}
			
			else if(grid[y1][x1] == RED){ // all red pieces 
				
				if(x1 > 0 && grid[y1+1][x1-1] == BLACK && grid[y1-2][x1-2] == 0){ // if there is a red piece that can be captured followed by empty spot (left side)
					grid[y1+2][x1-2] = RED; // set moved to red
					grid[y1+1][x1-1] = 0; // set the captured piece to empty 
					grid[y1][x1] = 0; // set original to empty
				}
				else if(x1 < 7 && grid[y1+1][x1+1] == BLACK && grid[y1+2][x1+2] == 0){ //if there is a red piece that can be captured followed by empty spot (right side)
					grid[y1+1][x1+1] = 0; // set the captured piece to empty
					grid[y1+2][x1+2] = RED; // set moved to red
					grid[y1][x1] = 0; // set original to empty
				}
				else if (x1 > 0 && grid[y1+1][x1-1]== BLACK && grid[y1+2][x1-2] == 0 && grid[y1+3][x1-1] == BLACK && grid[y1+4][x1] == 0){ // if double jump is possible (left side)
					grid[y1+1][x1-1] = 0; // set the first captured piece to empty
					grid[y1+3][x1-2] = 0; // set the second captured piece to empty
					grid[y1+4][x1] = RED; // set moved to red
					grid[y1][x1] = 0; // set original to empty 
				}
				else if (x1 < 7 && grid[y1+1][x1+1]== BLACK && grid[y1+2][x1+2] == 0 && grid[y1+3][x1+1] == BLACK && grid[y1+4][x1] == 0){ // if double jump is possible (right side)
					grid[y1+1][x1+1] = 0; // set the first captured piece to empty
					grid[y1+3][x1+2] = 0; // set the second captured piece to empty
					grid[y1+4][x1] = RED; // set moved to red
					grid[y1][x1] = 0; // set original to empty 
				}
			}
		}
		System.out.println("This is a valid move (True)");
		System.out.println("");
		this.display();
	}
	
	public void display(){
		// display method that displays the checkers board 
		for(int i = 0; i < 8; i++){
			System.out.println("+---+---+---+---+---+---+---+---+");
			System.out.print("|");
			for(int j = 0; j < 8; j++){
				if(grid[i][j] == BLACK){
					System.out.print(" X |");
				}
				else if(grid[i][j] == RED){
					System.out.print(" O |");
				}
				else{
					System.out.print("   |");
				}
			}
			System.out.println("");
		}
		System.out.println("+---+---+---+---+---+---+---+---+");
	}
}