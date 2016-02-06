import java.util.Scanner;

public class BricksGame {

	public BricksGame() {
	}

	public static void main(String[] args) {
		BricksGame bg = new BricksGame();
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();
		while (T > 0) {

			int N = in.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			int score = bg.pickBricks(arr, 0, 1, 0);

			System.out.println(score);

			T--;
		}

		in.close();

	}

	// 1 is my move, 2 is other
	public int pickBricks(int[] arr, int idx, int turn, int myScore) {

		// 3 or less bricks left, just return score
		if ((arr.length - idx) <= 3) {
			// calculate remaining score if my turn
			if (turn == 1) {
				for (int i = idx; i < arr.length; i++) {
					myScore += arr[i];
				}
			}
			return myScore;
		}

		// swap turns
		if (turn == 1) {
			turn = 2;
			int myScore1 = myScore + arr[idx];
			int myScore2 = myScore + arr[idx] + arr[idx + 1];
			int myScore3 = myScore + arr[idx] + arr[idx + 1] + arr[idx + 2];
			return Math.max(pickBricks(arr, idx + 1, turn, myScore1),
					Math.max(pickBricks(arr, idx + 2, turn, myScore2), pickBricks(arr, idx + 3, turn, myScore3)));
		} else {
			turn = 1;
			return Math.max(pickBricks(arr, idx + 1, turn, myScore),
					Math.max(pickBricks(arr, idx + 2, turn, myScore), pickBricks(arr, idx + 3, turn, myScore)));
			// return pickBricks(arr, idx + 3, turn, myScore);

		}

	}

}
