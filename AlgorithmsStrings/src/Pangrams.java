import java.util.Hashtable;
import java.util.Scanner;


public class Pangrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<Character, Integer> alphamap = new Hashtable<Character, Integer>();
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		for(int i=0; i<alpha.length(); i++){
			alphamap.put(alpha.charAt(i), 0);
		}
		
		Scanner in = new Scanner(System.in);
		String[] line = in.nextLine().toLowerCase().trim().split(" ");
		
		for(int w=0; w<line.length; w++){
			String word = line[w];
			for(int i=0; i<word.length(); i++){
				alphamap.put(word.charAt(i), alphamap.get(word.charAt(i))+1);
			}
		}
		
		for(int i=0; i<alpha.length(); i++){
			if(alphamap.get(alpha.charAt(i)) == 0){
				System.out.println("not pangram");
				System.exit(0);
			}
		}
		System.out.println("pangram");
	}

}
