import java.util.Scanner;

public class CountingSort2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int[] buckets = new int[100];

		for (int i = 0; i < 100; i++) {
			buckets[i] = 0;
		}

		int M = N;
		while (M > 0) {
			int num = in.nextInt();
			buckets[num]++;

			M--;
		}

		for (int i = 0; i < 100; i++) {
			for (int j = buckets[i] - 1; j >= 0; j--) {
				System.out.print(i + " ");
			}
		}
	}

}
