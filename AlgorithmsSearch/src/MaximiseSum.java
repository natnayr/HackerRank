import java.util.Scanner;

public class MaximiseSum {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		long T = in.nextInt();
		
		while(T>0){
			
			int N = in.nextInt();
			long M = in.nextInt();
			
			long[] arr = new long[N];
//			int[][] searchBox = new int[N][N];
			long max = 0;
			
			
			for(int i=0; i<N; i++){
				arr[i] = in.nextInt();
			}
			
			boolean found = false;
			long x=1;
			for(int j=0; j<N && found == false; j++){
				for(int i = 0; i<N && i<x && found == false; i++){
					long modSum = (arr[i] + arr[j]) % M;
					if(max < modSum){
						max = modSum;
						if(modSum == M-1){
							found = true;
						}
					}
				}
				x++;
			}
			
			System.out.println(max);
			
			T--;
		}
		
		in.close();
	}
	
}
