import java.util.*;
class GamewordTest{
	public static void main (String [] args){
		Gameword wrd = new Gameword("Usman");
//		System.out.println("Check anagram: " + wrd.isanagram("Ghanem"));
//		System.out.println("Reversed word: " +wrd.reverse());
//		System.out.println("Contents: " + wrd.toString());
//		System.out.println("Permutation of contents : " + wrd.permutation());
		System.out.println("Points: " + wrd.Pointvalue(7,7,1));
	}
}