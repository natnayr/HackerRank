import java.util.Scanner;


public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int arr[][] = new int[size][size];
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				arr[i][j] = in.nextInt();
			}
		}
		
		//get first diagonal
		int a = 0;
		for(int i=0; i<size; i++){
			a += arr[i][i];
		}
		
		int b = 0;
		for(int i=0, j=size-1; i<size && j>=0; i++,j--){
			b += arr[i][j];
		}
		System.out.println(Math.abs(a-b));
		
	}

}
