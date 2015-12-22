import java.util.Hashtable;
import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T>0){
			int M = in.nextInt();
			int N = in.nextInt();
			Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
			
			
			for(int idx=0; idx<N; idx++){
				int num = in.nextInt();
				//find match first
				int toFindNum = M - num;
				Integer pair = null;
				if((pair = ht.get(toFindNum)) != null){
					int foundDex = idx+1;
					int foundPair = pair+1;
					System.out.println(foundPair + " " + foundDex);
				}else{
					ht.put(num, idx);
				}
			}
			
			T--;
		}

	}

}
