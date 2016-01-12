import java.util.Scanner;

public class SnakesAndLaddersTheQuickestWayUp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T > 0) {

			Square[] board = new Square[100];
			for (int i = 0; i < 100; i++) {
				board[i] = new Square();
				int rollNum = (i + 1) / 6;
				if (((i + 1) % 6) != 0) {
					rollNum += 1;
				}
				board[i].setRolls(rollNum);
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
			int sixCount = 0;
			int curRoll = 1;
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

				sixCount++;
				i++;

				// set rolls
				if (sixCount > 6) {
					sixCount = 0;
					curRoll++;
				}
			}

			System.out.println(board[99].getRolls());

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