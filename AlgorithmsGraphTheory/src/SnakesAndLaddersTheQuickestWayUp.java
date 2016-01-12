import java.util.Scanner;

public class SnakesAndLaddersTheQuickestWayUp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T > 0) {

			Square[] board = new Square[100];
			board[0] = new Square();
			board[0].setRolls(0);

			int sixCount = 1;
			int curRoll = 1;
			for (int i = 1; i < 100; i++) {
				board[i] = new Square();
				board[i].setRolls(curRoll);

				sixCount++;

				// set rolls
				if (sixCount > 6) {
					sixCount = 1;
					curRoll++;
				}
			}

			int L = in.nextInt();
			for (int i = 0; i < L; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				board[start - 1].moveTo = end - 1;
				board[end - 1].isExit = true;
				board[end - 1].moveFrom = start - 1;
			}

			int S = in.nextInt();
			for (int i = 0; i < S; i++) {
				int start = in.nextInt();
				int end = in.nextInt();
				board[start - 1].moveTo = end - 1;

				board[end - 1].moveFrom = start - 1;
			}

			int i = 0;
			// hit last square and escape
			while (i < 100) {

				// ladder
				if (board[i].moveTo > i && board[i].moveTo != -1) {
					int lEndIdx = board[i].moveTo;
					if (board[lEndIdx].getRolls() > board[i].getRolls()) {
						board[lEndIdx].setRolls(board[i].getRolls());
						changeBoardTillEnd(board, lEndIdx);
					}
				}

				// snake
				if (board[i].moveTo < i && board[i].moveTo != -1) {
					int snakeEndIdx = board[i].moveTo;
					if (board[snakeEndIdx].getRolls() > board[i].getRolls()) {
						board[snakeEndIdx].setRolls(board[i].getRolls());
						changeBoardTillEnd(board, snakeEndIdx);
					}
				}

				i++;

			}

			if (board[99].getRolls() == 14) {
				System.out.println(-1);
			} else {
				System.out.println(board[99].getRolls());
			}

			T--;
		}
		in.close();
	}

	public static void changeBoardTillEnd(Square[] board, int i) {

		int curRoll = board[i].getRolls() + 1; // next roll to move
		i += 1;
		int sixCount = 0;

		while (i < 100) {

			if (curRoll < board[i].getRolls()) {
				board[i].setRolls(curRoll);
			}

			// ladder
			if (board[i].moveTo > i && board[i].moveTo != -1) {
				// set ladder if less and move through
				int ladderIdx = board[i].moveTo;
				if (board[i].getRolls() < board[ladderIdx].getRolls()) {
					board[ladderIdx].setRolls(board[i].getRolls());
					i = ladderIdx; // continue from ladder exit
					sixCount = 0;
					curRoll++;
				}
			}

			// snake
			if (board[i].moveTo < i && board[i].moveTo != -1) {
				// set snake if less and move through
				int snakeIdx = board[i].moveTo;
				if (board[i].getRolls() < board[snakeIdx].getRolls()) {
					board[snakeIdx].setRolls(board[i].getRolls());
					i = snakeIdx;
					sixCount = 0;
					curRoll++;
				}
			}

			sixCount++;
			i++;

			// set rolls
			if (sixCount > 5) {
				sixCount = 0;
				curRoll++;
			}
		}
	}
}

class Square {
	private int rolls = Integer.MAX_VALUE;
	public int moveTo = -1;
	public int moveFrom = -1;
	public boolean isExit = false;

	public void setRolls(int roll) {
		this.rolls = roll;
	}

	public int getRolls() {
		return this.rolls;
	}
}