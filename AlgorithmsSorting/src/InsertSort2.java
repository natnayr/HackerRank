import java.util.Scanner;


public class InsertSort2 {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++){
			arr[i] = in.nextInt();
		}
		//right to left
		for(int i=1; i<n; i++){
			if(arr[i-1] > arr[i]){
				
				//shifting down
				for(int j=i; j>0; j--){
					if(arr[j-1] > arr[j]){
						int e = arr[j-1];
						arr[j-1] = arr[j];
						arr[j] = e;
					}else{
						break;
					}
				}
				
			}
			print(arr);
		}
	}
	
	public static void print(int[] arr){
		System.out.print(arr[0]);
		for(int i=1; i<arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
		
	}
	
}
