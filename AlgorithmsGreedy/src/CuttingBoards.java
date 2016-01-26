import java.math.BigInteger;
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
			long[] arrX = new long[m - 1];
			long[] arrY = new long[n - 1];

			for (int i = 0; i < m - 1; i++) {
				arrX[i] = in.nextLong();
			}

			for (int i = 0; i < n - 1; i++) {
				arrY[i] = in.nextLong();
			}

			Arrays.sort(arrX);
			Arrays.sort(arrY);

			for (int i = 0; i < (m - 1) / 2; i++) {
				long temp = arrX[i];
				arrX[i] = arrX[m - 2 - i];
				arrX[m - 2 - i] = temp;
			}

			for (int i = 0; i < (n - 1) / 2; i++) {
				long temp = arrY[i];
				arrY[i] = arrY[n - 2 - i];
				arrY[n - 2 - i] = temp;
			}

			int numXPlates = 1;
			int numYPlates = 1;
			BigInteger totalCost = BigInteger.ZERO;

			int idx = 0;
			int idy = 0;

			while ((idx != arrX.length) || (idy != arrY.length)) {

				if (idx != arrX.length && idy == arrY.length) {
					totalCost = totalCost.add(BigInteger.valueOf(arrX[idx] * numYPlates));
					numXPlates++;
					idx++;
				} else if (idy != arrY.length && idx == arrX.length) {
					totalCost = totalCost.add(BigInteger.valueOf(arrY[idy] * numXPlates));
					numYPlates++;
					idy++;
				} else if (idy != arrY.length && idx != arrX.length) {
					if (arrX[idx] > arrY[idy]) {
						totalCost = totalCost.add(BigInteger.valueOf(arrX[idx] * numYPlates));
						numXPlates++;
						idx++;
					} else if (arrX[idx] < arrY[idy]) {
						totalCost = totalCost.add(BigInteger.valueOf(arrY[idy] * numXPlates));
						numYPlates++;
						idy++;
					} else {
						if ((arrX[idx] * numYPlates) < (arrY[idy] * numXPlates)) {
							totalCost = totalCost.add(BigInteger.valueOf(arrX[idx] * numYPlates));
							numXPlates++;
							idx++;
						} else {
							totalCost = totalCost.add(BigInteger.valueOf(arrY[idy] * numXPlates));
							numYPlates++;
							idy++;
						}
					}
				}

			}

			double pow = Math.pow(10, 9) + 7;
			totalCost = totalCost.mod(BigInteger.valueOf((long) pow));
			System.out.println(totalCost.toString());
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
