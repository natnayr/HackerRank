import java.util.Scanner;

public class MinStepToOneDP {

	public static int[] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		dp = new int[n + 1]; // reflect actual numbers
		dp[1] = 0; // trival cause already at 1

		for (int i = 2; i <= n; i++) {
			dp[i] = 1 + dp[i - 1];
			if (i % 2 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
			if (i % 3 == 0)
				dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
		}

		System.out.println(dp[n]);

		for (int i = 1; i <= n; i++) {
			System.out.print(dp[i] + " ");
		}

		in.close();
	}

}
