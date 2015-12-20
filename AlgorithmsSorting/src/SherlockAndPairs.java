import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SherlockAndPairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T>0){
			
			int N = in.nextInt();
			
			HashMap<Long,Long> hs = new HashMap<Long,Long>();
			for(long i=0; i<N; i++){
				long num = in.nextInt();
				Long count;
				if((count = hs.get(num)) == null){
					hs.put(num, (long) 1);
				}else{
					hs.put(num, count+1);
				}
				
			}
			
			long totalCount = 0;
			Iterator<Long> hsit = hs.values().iterator();
			while(hsit.hasNext()){
				long num = hsit.next();
				if(num > 1){
					totalCount += num * (num-1);
				}
			}
			System.out.println(totalCount);
			
			T--;
		}
		in.close();

	}

}
