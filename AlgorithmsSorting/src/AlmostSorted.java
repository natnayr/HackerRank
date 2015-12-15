import java.util.Scanner;

public class AlmostSorted {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		int dip = 0;
		int up = 0;

		// run through 1 to N-2, leave first and last
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
				up++;
			}

			if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
				dip++;
			}
		}

		System.out.println("up:" + up);
		System.out.println("dip:" + dip);
	}
}
