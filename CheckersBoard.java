

import java.util.*;
public class CheckersBoard {
	
public static final int BLACK = 1;
	public static final int RED = 2;
	private int [][] grid;
							  
public CheckersBoard(int[][] grid){
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
	public boolean move(int x1, int y1, int x2, int y2){
		return move(x1,y1,x2,y2,2,"");
	}
	public boolean move(int x1, int y1, int x2, int y2, int colour, String movement){
		if(x1 == x2 && y1 == y2){
			return true;
		}
		else{
			if(colour == BLACK){
				if(y1 < y2 && x1 > 0 && x1 < 7){
					if (grid[y1 - 1][x1 - 1] == 0){
						move(x1 - 1, y1 - 1, x2 , y2, colour, movement + "1");
					}
					else if(grid[y1 - 1][x1 + 1] == 0){
						move(x1 + 1, y1 - 1, x2, y2, colour, movement + "2");
					}
					else if (grid[y1 - 1][x1 - 1] == RED && grid[y1 - 2][x1 - 2] == 0){
						grid[y1 - 1][x1 - 1] = 0;
						move(x1 - 2, y1 - 2, x2, y2, colour, movement + "3");
					}
					else if (grid[y1 - 1][x1 + 1] == RED && grid[y1 - 2] [x1 + 2] == 0){
						grid[y1 - 1][x1 + 1] = 0;
						move(x1 + 2, y1 - 2, x2, y2, colour, movement + "4");
					}
				}
			}
			
			else if(colour == RED){
				if(y1 > y2 && x1 > 0 && x1 < 7){
					if (grid[y1 + 1][x1 - 1] == 0){
						move(x1 - 1, y1 + 1, x2 , y2, colour, movement + "1");
					}
					else if(grid[y1 + 1][x1 + 1] == 0){
						move(x1 + 1, y1 + 1, x2, y2, colour, movement + "2");
					}
					else if (grid[y1 + 1][x1 - 1] == BLACK && grid[y1 + 2][x1 - 2] == 0){
						grid[y1 + 1][x1 - 1] = 0;
						move(x1 - 2, y1 + 2, x2, y2, colour, movement + "3");
					}
					else if (grid[y1 + 1][x1 + 1] == BLACK && grid[y1 + 2] [x1 + 2] == 0){
						grid[y1 + 1][x1 + 1] = 0;
						move(x1 + 2, y1 + 2, x2, y2, colour, movement + "4");
					}
				}
			}
		}
		if(movement != ""){
				return false;
			}
		else{
			return true;
		}
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