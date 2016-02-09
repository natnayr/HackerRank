import java.util.Scanner;

public class MaximumSubArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		while (T > 0) {

			int N = in.nextInt();
			int[] arr = new int[N];

			int[] dp = new int[N + 1];

			int posTotal = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();

				if (arr[i] > 0)
					posTotal += arr[i];

				dp[i] = 0; // init dp[]
			}
			dp[N] = 0;

			for (int i = 0; i < N; i++) {

			}

			System.out.println(posTotal);

			T--;
		}

		in.close();
	}

}
