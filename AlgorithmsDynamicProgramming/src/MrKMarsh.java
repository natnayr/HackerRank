import java.util.LinkedList;
import java.util.Scanner;

public class MrKMarsh {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = in.next().toCharArray();
		}

		int[][] upLand = new int[N][M];
		int[][] leftLand = new int[N][M];

		for (int i = 0; i < N; i++) {
			int count = 0;
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'x') {
					count = -1;
				}
				leftLand[i][j] = count;
				count++;
			}
		}

		for (int j = 0; j < M; j++) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 'x') {
					count = -1;
				}
				upLand[i][j] = count;
				count++;
			}
		}

		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(upLand[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(leftLand[i][j] + "\t");
			}
			System.out.println();
		}

		int max_par = -1;

		for (int r1 = 0; r1 < N; r1++) {
			for (int r2 = r1 + 1; r2 < N; r2++) {
				LinkedList<Integer> v = new LinkedList<Integer>();
				int rDiff = r2 - r1;
				for (int j = 0; j < M; j++) {
					if (upLand[r2][j] >= rDiff) {
						v.push(j);
					}
				}
				int l = 0, r;
				for (r = 0; r < v.size(); r++) {
					int minLeft = Math.min(leftLand[r1][v.get(r)], leftLand[r2][v.get(r)]);
					while (v.get(l) < minLeft)
						l++;
					if (v.get(r) > v.get(l))
						max_par = Math.max(max_par, 2 * (rDiff) + 2 * (v.get(r) - v.get(l)));
				}
			}
		}

		System.out.println(max_par);
		in.close();
	}

}
