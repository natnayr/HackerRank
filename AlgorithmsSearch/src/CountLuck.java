import java.util.Scanner;

public class CountLuck {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {
			int N = in.nextInt();
			int M = in.nextInt();

			char[][] map = new char[N][M];
			int stX = -1, stY = -1, endX = -1, endY = -1;

			for (int i = 0; i < N; i++) {
				String line = in.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);

					if (map[i][j] == '*') {
						endX = i;
						endY = j;
					}

					if (map[i][j] == 'M') {
						stX = i;
						stY = j;
					}
				}
			}

			if (stX == -1 || stY == -1 || endX == -1 || endY == -1) {
				throw new NullPointerException();
			}

			int K = in.nextInt();
			boolean found = false;
			int curX = stX, curY = stY;

			while (found == false) {

			}

			T--;
		}

		in.close();

	}

}
