import java.util.Scanner;


public class ServiceLane {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = in.nextInt();
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++){
			arr[i] = in.nextInt();
		}
		
		while(T > 0){
			
			int i = in.nextInt();
			int j = in.nextInt();
			if(i >= j){
				System.out.println("err");
			}
			
			int smallest = 3;
			for(int k=i; k<=j; k++){
				if(arr[k] < smallest){
					smallest = arr[k];
				}
			}
			
			System.out.println(smallest);
			T--;
		}
	}

}
