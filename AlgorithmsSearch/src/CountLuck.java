import java.util.LinkedList;
import java.util.Scanner;

public class CountLuck {

	public static char[][] map;
	public static int M;
	public static int N;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {
			N = in.nextInt() + 2;
			M = in.nextInt() + 2;

			map = new char[N][M];
			int stX = -1, stY = -1, endX = -1, endY = -1;

			// fill boarders
			for (int j = 0; j < M; j++) {
				map[0][j] = 'X';
				map[N - 1][j] = 'X';
			}

			for (int i = 0; i < N; i++) {
				map[i][0] = 'X';
				map[i][M - 1] = 'X';
			}

			// fill insides
			for (int i = 1; i < N - 1; i++) {
				String line = in.next();
				for (int j = 1; j < M - 1; j++) {
					map[i][j] = line.charAt(j - 1);

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

			int K = in.nextInt();

			LinkedList<Path> stack = new LinkedList<Path>();
			stack.push(new Path(stX, stY, 0));
			int doneCount = 0;

			while (stack.size() > 0) {
				Path cur = stack.pop();
				int x = cur.x;
				int y = cur.y;
				int optionsCount = cur.optionsCount;

				if (x == endX && y == endY) {
					doneCount = optionsCount;
					break;
				}

				// mark
				map[x][y] = 'X';
				int options = 0;

				if (map[x - 1][y] != 'X') {
					options++;
				}

				if (map[x + 1][y] != 'X') {
					options++;
				}

				if (map[x][y - 1] != 'X') {
					options++;
				}

				if (map[x][y + 1] != 'X') {
					options++;
				}

				if (options > 1) {
					optionsCount++;
				}

				if (map[x - 1][y] != 'X') {
					stack.push(new Path(x - 1, y, optionsCount));

				}

				if (map[x + 1][y] != 'X') {
					stack.push(new Path(x + 1, y, optionsCount));

				}

				if (map[x][y - 1] != 'X') {
					stack.push(new Path(x, y - 1, optionsCount));

				}

				if (map[x][y + 1] != 'X') {
					stack.push(new Path(x, y + 1, optionsCount));

				}

			}

			if (doneCount == K) {
				System.out.println("Impressed");
			} else {
				System.out.println("Oops!");
			}

			T--;
		}

		in.close();

	}

}

class Path {
	public int x;
	public int y;
	public int optionsCount;

	public Path(int x, int y, int optionsCount) {
		this.x = x;
		this.y = y;
		this.optionsCount = optionsCount;
	}
}