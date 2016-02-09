import java.util.Scanner;

public class MinStepToOneMemoization {

	public static int[] memo;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		memo = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			memo[i] = -1;
		}

		int r = minSteps(n);

		System.out.println(r);

		in.close();
	}

	public static int minSteps(int n) {

		if (n == 1)
			return 0;

		if (memo[n] != -1)
			return memo[n]; // done before just return the min

		int r = 1 + minSteps(n - 1); // try for -1

		if (n % 2 == 0)
			// try for /2 if %2
			r = Math.min(r, minSteps(n / 2) + 1);

		if (n % 3 == 0)
			// try for /3 if %3
			r = Math.min(r, minSteps(n / 3) + 1); // 1 is the current step

		memo[n] = r; // store

		return r;
	}

}
