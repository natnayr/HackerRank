import java.util.Scanner;

public class CountingSort3 {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int[] bucket = new int[100];

		for (int i = 0; i < 100; i++) {
			bucket[i] = 0;
		}

		while (T > 0) {
			int num = in.nextInt();
			in.next();

			bucket[num]++;
			T--;
		}

		int count = 0;
		for (int i = 0; i < 100; i++) {
			if (bucket[i] > 0)
				count += bucket[i];
			System.out.print(count + " ");
		}

	}
}
