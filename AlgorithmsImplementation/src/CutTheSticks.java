import java.util.Scanner;


public class CutTheSticks {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[] arr = new int[N];
		
		int length = 1000;
		//init jumpArr running numbers & input arr
		for(int i=0; i<N; i++){
			arr[i] = in.nextInt();
			
			if(arr[i] < length){
				length = arr[i];
			}
		}
		
		
		//walk through and start
		while(true){
			int cutCount = 0;
			int smallest = 1000;
		
			for(int i=0; i<N; i++){
				
				if(arr[i] >= length){
					arr[i] -= length;
					cutCount++;
				}
				
				if(arr[i] > 0 && arr[i] < smallest){
					smallest = arr[i];
				}
			}
			
			if(cutCount == 0){
				break;
			}
			System.out.println(cutCount);
			length = smallest;
		}
	}
	
}
