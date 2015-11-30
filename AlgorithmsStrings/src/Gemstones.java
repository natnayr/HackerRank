
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
		String abc = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i=0; i<abc.length(); i++){
			hash.put(abc.charAt(i), 0);
		}
		
		
		while(T > 0){
			String rock = in.next().toLowerCase().trim();
			LinkedList<Character> dump = new LinkedList<Character>();
			
			for(int i=0; i<rock.length(); i++){
				char element = rock.charAt(i);
				if(!dump.contains(element)){
					hash.put(element, hash.get(element) + 1);
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
