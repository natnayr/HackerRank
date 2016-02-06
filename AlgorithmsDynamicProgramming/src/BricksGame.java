import java.util.Scanner;

public class BricksGame {

	public int[] sum;
	public int[] dp;
	public int[] arr;

	public BricksGame() {
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		while (T > 0) {
			BricksGame bg = new BricksGame();
			int N = in.nextInt();

			bg.arr = new int[N];
			bg.sum = new int[N];
			bg.dp = new int[N + 1];

			for (int i = 0; i < N; i++) {
				bg.arr[i] = in.nextInt();
				bg.dp[i] = 0;
			}

			bg.sum[0] = bg.arr[0];
			for (int i = 1; i < N; i++) {
				bg.sum[i] = bg.arr[i] + bg.sum[i - 1];
			}

			bg.dp[0] = 0;
			bg.dp[1] = ;
			bg.dp[2] = bg.sum[2];

			for (int i = 3; i <= N; i++) {
				
			}

			T--;
		}

		in.close();

	}

}
