import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] childRating = new int[N];
		int[] childCandies = new int[N];

		for (int i = 0; i < N; i++) {
			childRating[i] = in.nextInt();
			childCandies[i] = 1;
		}

		for (int i = 1; i < N; i++) {

			if (childRating[i - 1] < childRating[i]) {
				childCandies[i] = childCandies[i - 1] + 1;
			}

			if (childRating[i - 1] == childRating[i]) {
				childCandies[i] = 1;
			}

		}

		for (int i = N - 1; i > 0; i--) {

			if (childRating[i - 1] > childRating[i]) {
				if (childCandies[i - 1] <= childCandies[i]) {
					childCandies[i - 1] = childCandies[i] + 1;
				}
			}

		}

		long totalCandies = 0;
		for (int i = 0; i < N; i++) {
			// System.out.print(" " + childCandies[i]);
			totalCandies += childCandies[i];
		}
		// System.out.println();
		System.out.println(totalCandies);

		in.close();
	}

}
