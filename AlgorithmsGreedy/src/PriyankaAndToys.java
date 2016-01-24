import java.util.Arrays;
import java.util.Scanner;

public class PriyankaAndToys {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
		}

		Arrays.sort(arr);

		int buyCount = 1;

		int x = arr[0];
		int y = arr[0] + 4;

		for (int i = 0; i < N; i++) {

			if (arr[i] >= x && arr[i] <= y) {
				continue;
			} else {
				buyCount++;
				x = arr[i];
				y = arr[i] + 4;
			}
		}

		System.out.println(buyCount);

		in.close();
	}

}
