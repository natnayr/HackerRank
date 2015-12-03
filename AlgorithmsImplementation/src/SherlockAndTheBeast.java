import java.util.Scanner;


public class SherlockAndTheBeast {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		while(T > 0){
			
			int N = in.nextInt();
			
			int pivot = getPivot(N);
			if(pivot < 0){
				System.out.println("-1");
			}else{
				
				for(int i=0; i<(pivot/3); i++){
					System.out.print("555");
				}
				
				for(int i=0; i<((N-pivot)/5); i++){
					System.out.print("33333");
				}
				System.out.println();
			}
			
			
			T--;
		}
	}
	
	//reduce pivot of n by 5 till it can be divided by 3
	public static int getPivot(int n){
		while(n>0){
			if((n%3) == 0){
				break;
			}else{
				n -= 5;
			}
		}
		
		return n;
	}
	
}
