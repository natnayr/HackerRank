import java.util.LinkedList;
import java.util.Scanner;

public class AlmostSorted {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt() + 2; //front and back corner cases
		int[] arr = new int[N];

		arr[0] = 0;
		for (int i = 1; i < N-1; i++) {
			arr[i] = in.nextInt();
		}
		arr[N-1] = 1000000;
		
		int dip = 0;
		int up = 0;
		
		LinkedList<Integer> upList = new LinkedList<Integer>();
		LinkedList<Integer> dipList = new LinkedList<Integer>();

		// run through 1 to N-2, leave first and last
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
				up++;
				upList.add(i);
			} else if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
				dip++;
				dipList.add(i);
			}
		}

		System.out.println("up: "+up);
		System.out.println("dip: "+dip);
		
		
		//swap
		if(up == 2 && dip == 2){
			
		}
		
		//reverse
		if(up == 1 && dip == 1){
			
		}
		
		in.close();
	}
}
