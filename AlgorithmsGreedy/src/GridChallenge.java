import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {

			int N = in.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String word = in.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = word.charAt(j) - 97;
				}
				Arrays.sort(arr[i]);
			}

			boolean lexi = true;
			int topOfGrid = 0;

			for (int i = 0; i < N && lexi == true; i++) {

				for (int j = 1; j < N && lexi == true; j++) {
					if (arr[i][j - 1] > arr[i][j]) {
						lexi = false;
						break;
					}
				}
			}

			for (int j = 0; j < N && lexi == true; j++) {
				for (int i = 1; i < N && lexi == true; i++) {
					if (arr[i - 1][j] > arr[i][j]) {
						lexi = false;
						break;
					}
				}
			}

			if (lexi) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

			T--;
		}

		in.close();
	}

}
