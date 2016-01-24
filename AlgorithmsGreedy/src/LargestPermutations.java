import java.util.Scanner;

public class LargestPermutations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int K = in.nextInt();
		int[] arr = new int[N];
		int n = N;

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		int i = 0;
		while (K > 0 && i < arr.length) {

			if (arr[i] != n) {
				// find n location
				int j = i;
				for (; j < N; j++) {
					if (arr[j] == n) {
						break;
					}
				}
				swap(arr, i, j);
				K--;
			}

			n--;
			i++;
		}

		for (i = 0; i < N; i++) {
			System.out.print(arr[i] + " ");
		}

		in.close();
	}

	public static void swap(int[] arr, int i, int j) {
		int cur = arr[i];
		arr[i] = arr[j];
		arr[j] = cur;
	}

}
