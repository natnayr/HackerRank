import java.util.Scanner;

public class StockMaximize {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {
			int N = in.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = in.nextInt();
			}

			int totalingIdx = 0;
			int curIdx = 0;
			long loot = 0;

			while (curIdx < N) {
				totalingIdx = curIdx;
				int nextMax = findMaxIdx(arr, curIdx);

				if (curIdx == nextMax) {
					curIdx++;
					continue;
				} else {
					curIdx = nextMax;
				}

				while (totalingIdx < curIdx) {
					loot += (arr[curIdx] - arr[totalingIdx]);
					totalingIdx++;
				}

				curIdx++;
			}

			System.out.println(loot);
			T--;
		}

		in.close();

	}

	public static int findMaxIdx(int[] arr, int fromIdx) {

		int maxIdx = fromIdx;
		int maxVal = arr[fromIdx];
		for (int i = fromIdx; i < arr.length; i++) {
			if (arr[i] > maxVal) {
				maxVal = arr[i];
				maxIdx = i;
			}
		}

		return maxIdx;
	}

}
