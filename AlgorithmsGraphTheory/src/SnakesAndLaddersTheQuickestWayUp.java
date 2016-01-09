import java.util.Scanner;

import sun.security.provider.certpath.Vertex;

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
				board[end - 1].isExit = true;
				board[end - 1].moveFrom = start - 1;
			}

			int i = 0;
			// hit last square and escape

			while (i < 100) {

				if (board[i].moveTo != -1) {

					if (board[i].moveTo > i) {
						// ladder
						int minRoll = Math.min(board[i].getRolls(), board[board[i].moveTo].getRolls());
						board[board[i].moveTo].setRolls(minRoll);
					} else {
						// snake
						if (board[i].getRolls() < board[board[i].moveTo].getRolls()) {
							board[board[i].moveTo].setRolls(board[i].getRolls());
							i = board[i].moveTo;
						}

					}
				} else {
					// normal square
					if ((i - 1) >= 0 && board[i - 1].isExit == true) {
						board[i].setRolls(board[i - 1].getRolls() + 1);

					} else if ((i - 6) >= 0 && board[i].isExit == false) {
						int setRoll = board[i - 1].getRolls();
						boolean plusOne = true;
						for (int j = i - 1; j >= 0 && j >= (i - 6); j--) {
							if (setRoll != board[j].getRolls()) {
								plusOne = false;
								break;
							}
						}

						if (plusOne) {
							board[i].setRolls(setRoll + 1);
						} else {
							board[i].setRolls(setRoll);
						}
					}
				}

				i++;
			}

			System.out.println(board[99].getRolls());

			T--;
		}
		in.close();
	}

	public static void findPath(Vertex Source) {

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