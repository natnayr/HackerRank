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

		// int topIdx = 0;
		// int leftIdx = 0;
		// int rightIdx = N - 1;
		// int btmIdx = M - 1;
		//
		// boolean foundRect = false;

		// while (foundRect == false && topIdx < btmIdx && leftIdx < rightIdx) {
		// boolean topClear = true, leftClear = true, rightClear = true,
		// btmClear = true;
		//
		// // topleft to topright
		// for (int i = leftIdx; i <= rightIdx; i++) {
		// if (map[topIdx][i] == true) {
		// topIdx++;
		// topClear = false;
		// break;
		// }
		// }
		//
		// // btmleft to btmright
		// for (int i = leftIdx; i <= rightIdx; i++) {
		// if (map[btmIdx][i] == true) {
		// btmIdx--;
		// btmClear = false;
		// break;
		// }
		// }
		//
		// // topLeft to btmRight
		// for (int i = topIdx; i <= btmIdx; i++) {
		// if (map[i][leftIdx] == true) {
		// leftIdx++;
		// leftClear = false;
		// break;
		// }
		// }
		//
		// // topRight to btmRight
		// for (int i = topIdx; i <= btmIdx; i++) {
		// if (map[i][rightIdx] == true) {
		// rightIdx--;
		// rightClear = false;
		// break;
		// }
		// }
		//
		// if (topClear == true && leftClear == true && rightClear == true &&
		// btmClear == true) {
		// foundRect = true;
		// }
		// }

		// System.out.println(topIdx + " " + btmIdx + " " + leftIdx + " " +
		// rightIdx);
		//
		// if (foundRect == false) {
		// System.out.println("impossible");
		// } else {
		// int totalSize = 2 * (btmIdx - topIdx) + 2 * (rightIdx - leftIdx);
		// System.out.println(totalSize);
		// }

		in.close();
	}

}
