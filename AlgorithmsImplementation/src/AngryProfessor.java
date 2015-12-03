import java.util.Scanner;


public class AngryProfessor {
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T > 0){
			int N = in.nextInt();
			int K = in.nextInt();
			
			int count = 0;
			for(int i=0; i<N; i++){
				if(in.nextInt() <= 0) count++;
			}
			
			if (K <= count) System.out.println("NO");
			else System.out.println("YES");
			
			T--;
		}
	}
	
}
