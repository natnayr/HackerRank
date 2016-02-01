import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {

			int N = in.nextInt();
			int Amount = in.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			// make map
			int[] map = new int[2000 + 1];
			initMemArray(map);

			for (int i = 0; i < arr.length; i++) {
				for (int sum = 1; sum <= Amount; sum++) {

					// int result = findMax(arr, sum, i);
					int element = arr[i];
					if (element <= sum) {
						map[sum] = Math.max(map[sum], (element + map[sum - element]));
					}

				}
			}

			System.out.println(map[Amount]);

			T--;
		}

		in.close();
	}

	public static void initMemArray(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			arr[i] = 0;
	}

}
