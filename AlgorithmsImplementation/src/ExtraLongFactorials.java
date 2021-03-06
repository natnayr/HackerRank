import java.util.Scanner;


public class ExtraLongFactorials {

	public static final int nBox = 200;
	
	public static void main(String[] args) {
		//100! = 9.3..e+157, thus digit array will be 160 long max
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int[] ans = new int[nBox];
	
		for(int i=0; i<nBox; i++){
			//init array
			ans[i] = 0;
		}
		
		//1
		ans[nBox-1] = 1;
		
		for(int i=1; i<=N; i++){
			ans = multiply(ans, i);
		}
		
		//print ans[]
		boolean zeros = true;
		for(int i=0; i<nBox; i++){
			if(zeros == true && ans[i] > 0){
				zeros = false;
			}
			if(zeros == false){
				System.out.print(ans[i]);
			}
		}
	}
	
	
	public static int[] multiply(int[] ans, int by){
		int[] carry = new int[nBox];
		for(int i=0; i<nBox; i++){
			//init carry array
			carry[i] = 0;
		}
		
		//start from right box and multiply (carry over) to left
		for(int i=nBox-1; i>=0; i--){
			int miniAns = (ans[i] * by) + carry[i];
			carry[i] = 0;
			if(miniAns > 0){
				ans[i] = (miniAns % 10);
				if(i-2 >= 0){
					carry[i-2] += miniAns / 100;
					miniAns -= (miniAns/100) * 100;
				}
				if(i-1 >= 0) carry[i-1] += miniAns / 10;
			}
		}
		
		return ans;
	}
}
