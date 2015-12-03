import java.util.Scanner;


public class InsertSort1 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		
		int[] arr = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = in.nextInt();
		}
		
		int e = arr[size-1];
		for(int i=size-1; i>=0; i--){
			if(arr[i] > e){
				arr[i+1] = arr[i];
			}else if(arr[i] <= e){
				arr[i] = e;
				break;
			}
			print(arr);
		}
		print(arr);
	}
	
	public static void print(int[] arr){
		System.out.print(arr[0]);
		for(int i=0; i<arr.length; i++){
			System.out.print(" " + arr[i]);
		}
		System.out.println();
	}

}
