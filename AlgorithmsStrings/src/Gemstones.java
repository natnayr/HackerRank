import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Gemstones {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = N;
		Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
		
		while(T > 0){
			String rock = in.next();
			LinkedList<Character> dump = new LinkedList<Character>();
			
			for(int i=0; i<rock.length(); i++){
				char element = rock.charAt(i);
				if(hash.containsKey(element) && dump.contains(element) == false){
					hash.put(element, hash.get(element) + 1);
				}else{
					hash.put(element, 1);
					
				}
				dump.add(element);
			}
			T--;
		}
		
		int count = 0;
		Iterator<Integer> lit = hash.values().iterator();
		while(lit.hasNext()){
			if(lit.next() == N){
				count++;
			}
		}
		System.out.println(count);
	}

}
