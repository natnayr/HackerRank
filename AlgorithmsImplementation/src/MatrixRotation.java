import java.util.LinkedList;
import java.util.Scanner;

public class MatrixRotation {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int M = in.nextInt();
		int N = in.nextInt();
		int R = in.nextInt();

		int[][] map = new int[M][N];
		int[][] result = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = in.nextInt();
			}
		}

		int startM = 0, startN = 0;

		int endM = M - 1, endN = N - 1;

		while (startM <= endM && startN <= endN) {

			LinkedList<Integer> movementList = new LinkedList<Integer>();

			// topLeft to topRight
			for (int j = startN; j <= endN; j++) {
				movementList.add(map[startM][j]);
			}

			// topRight +1 to btmRight
			for (int i = startM + 1; i <= endM; i++) {
				movementList.add(map[i][endN]);
			}

			// btmRight to btmLeft
			for (int j = endN - 1; j >= startN; j--) {
				movementList.add(map[endM][j]);
			}

			// btmLeft to topLeft
			for (int i = endM - 1; i >= startM + 1; i--) {
				movementList.add(map[i][startN]);
			}

			int r = R % movementList.size();

			for (int i = 0; i < r; i++) {
				movementList.addLast(movementList.poll());
			}

			// topLeft to topRight
			for (int j = startN; j <= endN; j++) {
				result[startM][j] = movementList.poll();
			}

			// topRight +1 to btmRight
			for (int i = startM + 1; i <= endM; i++) {
				result[i][endN] = movementList.poll();
			}

			// btmRight to btmLeft
			for (int j = endN - 1; j >= startN; j--) {
				result[endM][j] = movementList.poll();
			}

			// btmLeft to topLeft
			for (int i = endM - 1; i >= startM + 1; i--) {
				result[i][startN] = movementList.poll();
			}

			startM++;
			startN++;
			endM--;
			endN--;
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

		in.close();
	}
}
