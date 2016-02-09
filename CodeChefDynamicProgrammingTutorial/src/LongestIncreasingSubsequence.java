import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] arr = new int[N];
		int[] LS = new int[N]; // cache

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
			LS[i] = 0; // init to zero
		}

		// j<i and a[j] < a[i]
		for (int i = 0; i < N; i++) {
			LS[i] = 1; // trival case, initialises also
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && LS[j] >= LS[i]) { // second case for
															// undiscovered
					LS[i] = LS[j] + 1;
				}
			}
		}

		int longest = 0;
		for (int i = 0; i < N; i++) {
			if (longest < LS[i]) {
				longest = LS[i];
			}
			System.out.print(LS[i] + " ");
		}

		System.out.println("\n" + longest);

		in.close();

	}

}
