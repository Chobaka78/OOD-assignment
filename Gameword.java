/*
 *Usman Farooqi
 *Gamecontents.java
 */
import java.util.*;
class Gameword {
	
	// constants
	public static final int RIGHT = 1;
	public static final int DOWN = 2;
	private int x, y, direction;
	private String contents;
	
	// constructor 
	public Gameword(String contents){
		this.contents = contents.toUpperCase();
	}
	
	public Gameword(){
		this("");
	}
	
	// returns the contents as a string
	public String toString(){
		return contents;
	}
	
	// Scrabble board and all the point values of the letters
	int [][] grid =  {{4,0,0,1,0,0,0,4,0,0,0,1,0,0,4},
					  {0,2,0,0,0,3,0,0,0,3,0,0,0,2,0},
					  {0,0,2,0,0,0,1,0,1,0,0,0,2,0,0},
					  {1,0,0,2,0,0,0,1,0,0,0,2,0,0,1},
					  {0,0,0,0,2,0,0,0,0,0,2,0,0,0,0},
					  {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0},
					  {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
					  {4,0,0,1,0,0,0,5,0,0,0,1,0,0,4},
					  {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
					  {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0},
					  {0,0,0,0,2,0,0,0,0,0,2,0,0,0,0},
					  {1,0,0,2,0,0,0,1,0,0,0,2,0,0,1},
					  {0,0,2,0,0,0,1,0,1,0,0,0,2,0,0},
					  {0,2,0,0,0,3,0,0,0,3,0,0,0,2,0},
					  {4,0,0,1,0,0,0,4,0,0,0,1,0,0,4}};
					  
	int [] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10}; // value of each alphabetical letter in order
	
	//Calculates the point of the word
	public int Pointvalue(int x, int y, int direction){
		int score = points[contents.charAt(0)-65];
		int doubles = 0;
		int triples = 0;
		int pos;
		for(int i = 0; i < contents.length(); i++){
			pos = (int)contents.charAt(i) - 65 ; // these are all the ASCII letters from A-Z (65 is subtracted for capital letters only)
			if (grid[x][y] == 0){
				score += points[pos];
			}
			else if (grid[x][y] == 1){
				score += 2*points[pos];
			}
			else if (grid[x][y] == 2){
				doubles += 1;
			}
			else if (grid[x][y] == 3){
				score += (points[pos])*3;
			}
			else if (grid[x][y] == 4){
				triples += 1;
			}
			else if (grid[x][y] == 5){
				doubles += 1;
			}
			
			System.out.println("X: " + x +"," +"Y: " + y + "," + "Grid pos: " + grid[x][y] + "," + "points : " + points[pos] + "," + "score: " + score + "," + "letter pos :" + pos + "," + "doubles : " + doubles + "," + "Triples: " + triples);
			
			if(direction == RIGHT){
				x += 1;
			}
			else if(direction == DOWN){
				y += 1;
			}
		}
		
		if(doubles > 0){
			score *= (Math.pow(2,doubles));
		}
		if (triples > 0){
			score *= (Math.pow(3,triples));
		}
		return score;
	}
	// checks if a given word is an anargram from contents
	public boolean isanagram (String anoterWord){
		if(contents.length() != anoterWord.length()){// base case
			return false;
		}
		
		else{
			char [] contentsarray = contents.toUpperCase().toCharArray();
			char [] anagramarray = anoterWord.toUpperCase().toCharArray();
			// sorts the arrays
			Arrays.sort(contentsarray);
			Arrays.sort(anagramarray);
			// checks if the arrays are equal or not
			return Arrays.equals(contentsarray, anagramarray);
			}
	}
	
	// recursion functions that outputs a list of all the possible arrangements of contents 
	public ArrayList<String> permutation(){
		ArrayList<String> arrange = new ArrayList<String>();
		return permutation("",contents,arrange);
	}
	
	public ArrayList<String> permutation(String first, String word, ArrayList<String> arrange){
		
		if(word.length() == 0){
			arrange.add(first);
		}
		else{
				permutation(first + word.charAt(0), word.substring(1), arrange);
				permutation(first,word.substring(1),arrange);
		}
		return arrange;
	}
	
	public String reverse(){ // reversing the contents
		String revword = "";
		for (int i = contents.length()-1; i >= 0; i--){ // This loop takes the original contents and reverses it by adding each letter to an empty string in reverse order
			revword += contents.charAt(i);
		}
		return revword;
	}

}
