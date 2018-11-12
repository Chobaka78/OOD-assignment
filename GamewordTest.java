/**
 * Usman Farooqi
 * CheckersBoardTest.java
 * This program does has 5 methods for the game scabble 
 * 1. isanagram: checks if a given word is an anagram of contents 
 * 2. reverse: reverses the contens 
 * 3. tostring: outputs contents as a string
 * 4. permutations: returns an arraylist of all possible arrangements of contents
 * 5. PointValue: returns the score given in the game for the word if played in real life
 */
 
class GamewordTest{
	public static void main (String [] args){
		Gameword wrd = new Gameword("Usman");
		System.out.println("Check anagram: " + wrd.isanagram("wahid"));
		System.out.println("Reversed word: " +wrd.reverse());
		System.out.println("Contents: " + wrd.toString());
		System.out.println("Permutation of contents : " + wrd.permutation());
		System.out.println("Points: " + wrd.Pointvalue(0,0,1));
	}
}