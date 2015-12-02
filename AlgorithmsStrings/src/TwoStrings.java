import java.util.HashMap;
import java.util.Scanner;


public class TwoStrings {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T>0){
			String s1 = in.next();
			String s2 = in.next();
			
			HashMap<Character, Integer> table = new HashMap<Character, Integer>();
			for(int i=0; i<s1.length(); i++){
				table.put(s1.charAt(i), 1);
			}

			boolean match = false;
			for(int i=0; i<s2.length(); i++){
				if(table.containsKey(s2.charAt(i)) == true){
					match = true;
					break;
				}
			}
			
			if(match){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
			
			T--;
		}
	}
	
}
