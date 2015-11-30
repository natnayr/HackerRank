import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		while(T > 0){
			int N = in.nextInt();
			int C = in.nextInt();
			int M = in.nextInt();
			
			int chocCount = N/C;
			int wrapperCount = chocCount;
			
			while(wrapperCount >= M){
				int newChoc = (wrapperCount/M);
				wrapperCount = (wrapperCount%M) + newChoc;
				chocCount += newChoc;
				
			}
			System.out.println(chocCount);
		}
	}

}
