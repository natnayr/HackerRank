import java.util.Scanner;

public class SherlockAndArray {

	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while(T>0){
			int N = in.nextInt();
			int[] arr = new int[N];
			int[] fromLeft = new int[N];
			int[] fromRight = new int[N];
			
			int leftTotal = 0;
			for(int i=0; i<N; i++){
				int num = in.nextInt();
				leftTotal += num;
				arr[i] = num;
				fromLeft[i] = leftTotal;
			}
			
			int rightTotal = 0;
			for(int i=N-1; i>=0; i--){
				rightTotal += arr[i];
				fromRight[i] = rightTotal;
			}
			
			boolean found = false;
			for(int i=0; i<N; i++){
				if(fromLeft[i] == fromRight[i]){
					found = true;
					break;
				}
			}
			
			if(found == true){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
			
			
			T--;
		}
	}
	

}
