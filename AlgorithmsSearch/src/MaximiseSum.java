import java.util.Scanner;

public class MaximiseSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long T = in.nextInt();

		while (T > 0) {

			int N = in.nextInt();
			int M = in.nextInt();

			int[] arr = new int[N];
			int[] prefix = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			// prefix array, modulo arithmic (A+B)%M = (A%M + B%M)%M
			int curr = 0;
			for (int i = 0; i < N; i++) {
				curr = (arr[i] % M + curr) % M;
				prefix[i] = curr;
			}

			int ret = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i - 1; j >= 0; j--) {
					ret = Math.max(ret, (prefix[i] - prefix[j] + M) % M);
				}
				ret = Math.max(ret, prefix[i]);
			}

			System.out.println(ret);

			T--;
		}

		in.close();
	}
}
