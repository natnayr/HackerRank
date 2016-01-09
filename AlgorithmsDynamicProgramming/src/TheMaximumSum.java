import java.util.Scanner;

public class TheMaximumSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {
			int N = in.nextInt();
			long[] arr = new long[N];

			for (int i = 0; i < N; i++) {
				arr[i] = in.nextLong();
			}

			long bestConVal = maxSubArray(arr);
			long bestNonConVal = addAllPos(arr);
			System.out.println(bestConVal + " " + bestNonConVal);
			T--;
		}

		in.close();

	}

	public static long maxSubArray(long[] arr) {
		long curSum = 0;
		long bestSum = 0;

		for (int i = 0; i < arr.length; i++) {
			long val = curSum + arr[i];
			if (val > 0) {
				curSum = val;
			} else {
				curSum = 0;
			}

			if (curSum > bestSum) {
				bestSum = curSum;
			}
		}

		return bestSum;
	}

	public static long addAllPos(long[] arr) {
		long sum = 0;

		boolean added = false;
		for (int i = 0; i < arr.length; i++) {
			if (sum < (sum + arr[i])) {
				sum += arr[i];
				added = true;
			}
		}

		if (sum == 0 && added == false) {
			sum = arr[0];
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] > sum) {
					sum = arr[i];
				}
			}
		}

		return sum;
	}
}
