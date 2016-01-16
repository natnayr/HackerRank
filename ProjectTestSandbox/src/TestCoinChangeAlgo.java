import java.util.Scanner;

public class TestCoinChangeAlgo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n, m;
		n = in.nextInt();
		m = in.nextInt();

		int[] a = new int[m];

		for (int i = 0; i < m; i++) {
			a[i] = in.nextInt();
		}

		System.out.println(changeCount(a, n));
		in.close();
	}

	public static long changeCount(int[] a, int sum) {
		int l = a.length;

		int[][] sack = new int[l][sum + 1];

		for (int i = 0; i < l; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j < a[i]) {
					sack[i][j] = 0;
				} else if (j == a[i]) {
					sack[i][j] = 1;
				} else {
					int temp = j - a[i];
					sack[i][j] = 0;
					for (int k = 0; k <= i; k++) {
						sack[i][j] += sack[k][temp];
					}

				}

			}
		}
		int ret = 0;
		for (int i = 0; i < l; i++) {
			ret += sack[i][sum];
		}

		return ret;

	}
}
