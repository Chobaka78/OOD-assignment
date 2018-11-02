/*
 *Usman Farooqi
 *Gameword.java
 */
class Gameword {
	private double x, y, direction;

	public static void anagram(String word){
		anagram ("",word);
	}
	public static void anagram (String sofar, String left){
		if(left.equals("")){
			System.out.println(sofar);
		}
		else{
			for(int i = 0; i < left.length(); i++){
				String next = left.substring(0,i) + left.substring(i + 1);
				anagram(sofar + left.charAt(i),next);
			}
		}
	}

}
