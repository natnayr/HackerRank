import java.util.Scanner;

public class SansaAndXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		while (T > 0) {

			int N = in.nextInt();

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			if ((N % 2) == 0) {
				System.out.println(0);
			} else {

				int total = 0;

				// for (int size = 1; size <= N; size++) {
				// // System.out.println("size:" + size);
				// for (int start = 0, end = size - 1; end < N; start++, end++)
				// {
				//
				// int subSqn = 0;
				// // System.out.println("start:" + start + " end:" + end);
				//
				// for (int i = start; i <= end; i++) {
				//
				// // System.out.println("index:" + i);
				// if (arr[i] != 0) {
				// subSqn ^= arr[i];
				// }
				// }
				// if (subSqn != 0) {
				// total ^= subSqn;
				// }
				// }
				// }

				for (int i = 0; i < N; i += 2) {
					total ^= arr[i];
				}

				System.out.println(total);
			}
			T--;
		}

		in.close();

	}

}
