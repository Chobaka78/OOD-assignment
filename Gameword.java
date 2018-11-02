/*
 *Usman Farooqi
 *Gameword.java
 */
class Gameword {
	private double x, y, direction;

	public static void anagram(String word){//this is a recursion functions that will work as an anagram
		anagram ("",word);
	}
	public static void anagram (String sofar, String left){
		if(left.equals("")){// base case
			System.out.println(sofar);
		}
		else{
			for(int i = 0; i < left.length(); i++){
				String next = left.substring(0,i) + left.substring(i + 1);
				anagram(sofar + left.charAt(i),next);
			}
		}
	}
	
	public static void permutation(String letter){ // this is a recursion function that works as a permutation
		permutation("",letter);
	}
	
	public static void permutation(String first, String letter){
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
