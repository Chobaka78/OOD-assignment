

import java.util.*;
public class CheckersBoard {
	
public static final int BLACK = 1;
public static final int RED = 2;
private int [][] grid;
							  
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
	
	public boolean move(int x1, int y1, int x2, int y2){ // move method will return true or false (if move is valid)
		if(x1 < 0 && x1 > 7 && x2 < 0 && x2 > 7  && y1 < 0 && y1 > 7 && y2 < 0 && y2 > 7 ){ // makes the move false if all values are negative
			return false;
		}
		else {
			if(grid[y1][x1] == BLACK){ // checks for all black peices
			
				if (grid[y1 - 1][x1 - 1] == 0){ // move 1 up and 1 to the left
					move(x1 - 1, y1 - 1, x2 , y2);
				}
				else if(grid[y1 - 1][x1 + 1] == 0){ // move 1 up and 1 to the right
					move(x1 + 1, y1 - 1, x2, y2);
				}
				
				else if(grid[y1-1][x1-1] == RED && grid[y1-2][x1-2] == 0){ // if there is a red piece that can be captured followed by empty spot (left side)
					grid[y1-1][x1-1] = 0; // set captured piece to empty
					move(x1-2, y1-2, x2, y2);
				}
				else if(grid[y1-1][x1+1] == RED && grid[y1-2][x1+2] == 0){ // if there is a red piece that can be captured followed by empty spot (right side)
					grid[y1-1][x1+1] = 0; 
					move(x1+2, y1-2, x2, y2);
				}
				else if (grid[y1-1][x1-1]== RED && grid[y1-2][x1-2] == 0 && grid[y1-3][x1-1] == RED && grid[y1-4][x1] == 0){ // if double jump is possible
				// for double jump to be possible (there has to be a piece that can be captured followed by empty spot followed by another piece and empty spot
					grid[y1-1][x1-1] = 0; // set the first captrued piece to empty 
					grid[y1-3][x1-2] = 0; // set the second captured piece to empty 
					move(x1,y1-4,x2,y2);
				}
				else if (grid[y1-1][x1+1]== RED && grid[y1-2][x1+2] == 0 && grid[y1-3][x1+1] == RED && grid[y1-4][x1] == 0){ // if double jump is possilbe
					grid[y1-1][x1+1] = 0; // set the first captured piece to empty 
					grid[y1-3][x1+2] = 0; // set the second captured piece to empty 
					move(x1,y1-4,x2,y2);
				}
					
				return true; //  if any of these moves are possible return true
			}
			
			else if(grid[y1][x1] == RED){ // checking for all red pieces 
			
				if (grid[y1 + 1][x1 - 1] == 0){ // move 1 up and 1 to the left
					move(x1 - 1, y1 + 1, x2 , y2);
				}
				else if(grid[y1 + 1][x1 + 1] == 0){  // move 1 up and 1 to the right
					move(x1 + 1, y1 + 1, x2, y2);
				}
				
				else if(grid[y1+1][x1-1] == BLACK && grid[y1-2][x1-2] == 0){ // if there is a red piece that can be captured followed by empty spot (left side)
					grid[y1+1][x1-1] = 0; // set the captured piece to empty 
					move(x1-2, y1+2, x2, y2);
				}
				else if(grid[y1+1][x1+1] == BLACK && grid[y1-2][x1+2] == 0){ //if there is a red piece that can be captured followed by empty spot (right side)
					grid[y1+1][x1+1] = 0; // set the captured piece to empty
					move(x1+2, y1+2, x2, y2);
				}
				else if (grid[y1+1][x1-1]== BLACK && grid[y1+2][x1-2] == 0 && grid[y1+3][x1-1] == RED && grid[y1+4][x1] == 0){ // if double jump is possible
					grid[y1-1][x1-1] = 0; // set the first captured piece to empty
					grid[y1-3][x1-2] = 0; // set the second captured piece to empty
					move(x1,y1+4,x2,y2);
				}
				else if (grid[y1+1][x1+1]== BLACK && grid[y1+2][x1+2] == 0 && grid[y1+3][x1+1] == RED && grid[y1+4][x1] == 0){ // if double jump is possible
					grid[y1-1][x1+1] = 0; // set the first captured piece to empty
					grid[y1-3][x1+2] = 0; // set the second captured piece to empty
					move(x1,y1+4,x2,y2);
				}
				
				return true; // if all of these moves are possilbe return true
			}
		}
		return false; //  if none of the moves for red or black are possilbe return false 
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