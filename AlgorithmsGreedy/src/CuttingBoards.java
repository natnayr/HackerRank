import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CuttingBoards {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		while (T > 0) {

			int m = in.nextInt();
			int n = in.nextInt();
			int[] arrX = new int[m - 1];
			int[] arrY = new int[n - 1];

			for (int i = 0; i < m - 1; i++) {
				arrX[i] = in.nextInt();
			}

			for (int i = 0; i < n - 1; i++) {
				arrY[i] = in.nextInt();
			}

			Arrays.sort(arrX);
			Arrays.sort(arrY);

			for (int i = 0; i < (m - 1) / 2; i++) {
				int temp = arrX[i];
				arrX[i] = arrX[m - 2 - i];
				arrX[m - 2 - i] = temp;
			}

			for (int i = 0; i < (n - 1) / 2; i++) {
				int temp = arrY[i];
				arrY[i] = arrY[n - 2 - i];
				arrY[n - 2 - i] = temp;
			}

			int numXPlates = 1;
			int numYPlates = 1;
			long totalCost = 0;

			int idx = 0;
			int idy = 0;

			while ((idx != arrX.length) || (idy != arrY.length)) {

				if (idx != arrX.length && idy == arrY.length) {
					totalCost += arrX[idx] * numYPlates;
					totalCost %= ((long) Math.pow(10, 9) + 7);
					numXPlates++;
					idx++;
				} else if (idy != arrY.length && idx == arrX.length) {
					totalCost += arrY[idy] * numXPlates;
					totalCost %= ((long) Math.pow(10, 9) + 7);
					numYPlates++;
					idy++;
				} else if (idy != arrY.length && idx != arrX.length) {
					if (arrX[idx] > arrY[idy]) {
						totalCost += arrX[idx] * numYPlates;
						totalCost %= ((long) Math.pow(10, 9) + 7);
						numXPlates++;
						idx++;
					} else if (arrX[idx] < arrY[idy]) {
						totalCost += arrY[idy] * numXPlates;
						totalCost %= ((long) Math.pow(10, 9) + 7);
						numYPlates++;
						idy++;
					} else {
						if ((arrX[idx] * numYPlates) < (arrY[idy] * numXPlates)) {
							totalCost += arrX[idx] * numYPlates;
							totalCost %= ((long) Math.pow(10, 9) + 7);
							numXPlates++;
							idx++;
						} else {
							totalCost += arrY[idy] * numXPlates;
							totalCost %= ((long) Math.pow(10, 9) + 7);
							numYPlates++;
							idy++;
						}
					}
				}

			}
			System.out.println(totalCost % ((long) Math.pow(10, 9) + 7));

			T--;
		}

		in.close();

	}

	public class IntegerComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	}

}
