import java.util.LinkedList;
import java.util.Scanner;

public class ConnectedCellInAGrid {

	private static int[][] cell;
	private static boolean[][] searchedMap;
	private static int M;
	private static int N;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		M = in.nextInt();
		N = in.nextInt();

		cell = new int[M][N];
		searchedMap = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				cell[i][j] = in.nextInt();
				searchedMap[i][j] = false;
			}
		}

		int maxCount = 0;
		LinkedList<Pair> pairList = new LinkedList<Pair>();
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				
				if (searchedMap[i][j] == false && cell[i][j] == 1) {
					int count = 0;
					pairList.add(new Pair(i, j));
					
					while (pairList.size() > 0) {
						Pair cur = pairList.removeFirst();
						
						int x = cur.x;
						int y = cur.y;
						
						cell[x][y] = 0;
						count++;
						
						//left
						if (x > 0 && cell[x - 1][y] == 1){
							pairList.add(new Pair(x - 1, y));
							cell[x - 1][y] = 0;
						}
						
						//right
						if (x < M-1 && cell[x + 1][y] == 1){
							pairList.add(new Pair(x + 1, y));
							cell[x + 1][y] = 0;
						}
						
						//up
						if (y > 0 && cell[x][y - 1] == 1){
							pairList.add(new Pair(x, y - 1));
							cell[x][y - 1] = 0;
						}
						
						//down
						if (y < N-1 && cell[x][y + 1] == 1){
							pairList.add(new Pair(x, y + 1));
							cell[x][y + 1] = 0;
						}
						
						//top left
						if (x > 0 && y > 0 && cell[x - 1][y - 1] == 1){
							pairList.add(new Pair(x - 1, y - 1));
							cell[x - 1][y - 1] = 0;
						}
						
						//top right
						if (x < M-1 && y > 0 && cell[x + 1][y - 1] == 1){
							pairList.add(new Pair(x + 1, y - 1));
							cell[x + 1][y - 1] = 0;
						}
						
						//btm left
						if (x > 0 && y < N-1 && cell[x - 1][y + 1] == 1){
							pairList.add(new Pair(x - 1, y + 1));
							cell[x - 1][y + 1] = 0;
						}
						
						//btm right
						if (x < M-1  && y < N-1 && cell[x + 1][y + 1] == 1){
							pairList.add(new Pair(x + 1, y + 1));
							cell[x + 1][y + 1] = 0;
						}
					}

					if (maxCount < count)
						maxCount = count;
				}
			}
		}

		System.out.println(maxCount);
		in.close();
	}
}

class Pair {
	public int x;
	public int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}