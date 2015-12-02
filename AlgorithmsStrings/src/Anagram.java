import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;


public class Anagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T > 0){
			String readIn = in.next();
			int length = readIn.length();
			
			if((length % 2) != 0){
				System.out.println("-1");
				continue;
			}
			
			String s1 = readIn.substring(0, length/2);
			String s2 = readIn.substring(length/2, length);
			
			Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
			for(int i=0; i<(length/2); i++){
				Character cur = s1.charAt(i);
				if(hash.containsKey(cur)){
					hash.put(cur, hash.get(cur) + 1);
				}else{
					hash.put(cur, 1);
				}
			}
			
			for(int i=0; i<(length/2); i++){
				Character cur = s2.charAt(i);
				if(hash.containsKey(cur)){
					if(hash.get(cur) > 0){
						hash.put(cur, hash.get(cur) - 1);
					}
				}
			}
			
			int count = 0;
			Iterator<Integer> it = hash.values().iterator();
			while(it.hasNext()){
				count += it.next();
			}
			System.out.println(count);
			T--;
		}
		
	}

}
