/*
 *Usman Farooqi
 *Gameword.java
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
		
	// Scrabble board and all the point values of the letters
	int [][] grid =  {{4,0,0,1,0,0,0,4,0,0,0,1,0,0,4},
					  {0,2,0,0,0,3,0,0,0,3,0,0,0,2,0},
					  {0,0,2,0,0,0,1,0,1,0,0,0,2,0,0},
					  {1,0,0,2,0,0,0,1,0,0,0,2,0,0,1},
					  {0,0,0,0,2,0,0,0,0,0,2,0,0,0,0},
					  {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0},
					  {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
					  {4,0,0,1,0,0,0,2,0,0,0,1,0,0,4},
					  {0,0,1,0,0,0,1,0,1,0,0,0,1,0,0},
					  {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0},
					  {0,0,0,0,2,0,0,0,0,0,2,0,0,0,0},
					  {1,0,0,2,0,0,0,1,0,0,0,2,0,0,1},
					  {0,0,2,0,0,0,1,0,1,0,0,0,2,0,0},
					  {0,2,0,0,0,3,0,0,0,3,0,0,0,2,0},
					  {4,0,0,1,0,0,0,4,0,0,0,1,0,0,4}};
					  
	int [] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10}; // value of each alphabetical letter in order
	
	public String reverse(){ // reversing the contents
		String revword = "";
		for (int i = contents.length()-1; i >= 0; i--){ // This loop takes the original contents and reverses it by adding each letter to an empty string in reverse order
			revword += contents.charAt(i);
		}
		return revword;
	}
	
	// checks if a given word is an anargram from contents
	public boolean isanagram (String anotherWord){
		if(contents.length() != anotherWord.length()){// base case
			return false;
		}
		
		else{
			char [] contentsarray = contents.toUpperCase().toCharArray(); // convert the contents into character array
			char [] anagramarray = anotherWord.toUpperCase().toCharArray(); // convert the given word to character array
			// sorts the arrays
			Arrays.sort(contentsarray); 
			Arrays.sort(anagramarray);
			// checks if the arrays are equal or not
			return Arrays.equals(contentsarray, anagramarray);
			}
	}
	
	//Calculates the point of the word
	public int pointValue(int x, int y, int direction){
		int score = 0;
		int doubles = 0;
		int triples = 0;
		int pos;
		for(int i = 0; i < contents.length(); i++){
			pos = (int)contents.charAt(i) - 65 ; // these are all the ASCII letters from A-Z (65 is subtracted for capital letters only)
			if (grid[x][y] == 0){
				score += points[pos]; //adding regular points
			}
			else if (grid[x][y] == 1){
				score += 2*points[pos]; // double letter score (multiplies the points of given letter by 2)
			}
			else if (grid[x][y] == 2){
				score += points[pos]; // add regular point
				doubles += 1; // increase the amount of double word scores by 1
			}
			else if (grid[x][y] == 3){
				score += (points[pos])*3; // tripple letter score (multiplies the points of given letter by 3)
			}
			else if (grid[x][y] == 4){ 
				score += points[pos]; // add regular points
				triples += 1; // increase the amount of triples word score by 1
			}
			
			if(direction == RIGHT){ 
				x += 1; // if the given direction is right increase the x
			}
			else if(direction == DOWN){
				y += 1; // if the given direction is down increase the y
			}
		}
		
		if(doubles > 0){ // if the amount of doubles is greater than 1
			score *= (Math.pow(2,doubles)); // score * (2^ amount of doubles)
		}
		if (triples > 0){ // if the amount of triples is greater than 1
			score *= (Math.pow(3,triples)); // score * (3^ amount of triples)
		}
		return score; // return the score
	}
	
	// recursion functions that outputs a list of all the possible arrangements of contents 
	public ArrayList<String> permutation(){
		ArrayList<String> arrange = new ArrayList<String>();
		return permutation("",contents,arrange);
	}
	
	public ArrayList<String> permutation(String first, String word, ArrayList<String> arrange){
		
		if(word.length() == 0){ // base case
			arrange.add(first);
		}
		else{
			for(int i = 0; i < word.length(); i++){ // adds the possilbe arrangements of contents to the arraylist 
				permutation(first + word.charAt(i), word.substring(0,i) + word.substring(i + 1, word.length()), arrange); 
			}
		}
		return arrange;
	}
	
	// returns the contents as a string
	public String toString(){
		return contents;
	}

}
