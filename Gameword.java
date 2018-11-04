/*
 *Usman Farooqi
 *Gameword.java
 */
import java.util.*;
class Gameword {
	private double x, y, direction;

	public void isanagram (String word, String anagram){
		boolean status = false;
		if(word.length() != anagram.length()){// base case
			status = false;
		}
		
		else{
			char [] wordarray = word.toCharArray();
			char [] anagramarray = anagram.toCharArray();
			// sorts the arrays
			Arrays.sort(wordarray);
			Arrays.sort(anagramarray);
			// checks if the arrays are equal or not
			status = Arrays.equals(wordarray, anagramarray);
			}
			
		if(status){
			System.out.println("True");
		}
		else{
			System.out.println("False");
		}
	}
	
	public void permutation(String letter){ // this is a recursion function that works as a permutation
		permutation("",letter);
	}
	
	public void permutation(String first, String letter){
		int n = letter.length();
		if(n==0){
			System.out.println(first);
		}
		else{
			for(int i = 0; i<n; i++){
				permutation(first + letter.charAt(i), letter.substring(0,i) + letter.substring(i + 1, n));
			}
		}
	}

}
