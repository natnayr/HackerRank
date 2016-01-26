import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmicCrush {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		ArrayList<BigInteger> arr = new ArrayList<BigInteger>();

		for (int i = 0; i <= N; i++) {
			arr.add(BigInteger.ZERO);
		}

		while (M > 0) {

			int a = in.nextInt();
			int b = in.nextInt();
			int sum = in.nextInt();

			arr.set(a, arr.get(a).add(BigInteger.valueOf(sum)));

			if (b + 1 <= N) {
				arr.set(b + 1, arr.get(b + 1).subtract(BigInteger.valueOf(sum)));
			}

			M--;
		}

		BigInteger max = BigInteger.ZERO;
		BigInteger x = BigInteger.ZERO;
		for (int i = 1; i <= N; i++) {
			x = x.add(arr.get(i));
			if (max.compareTo(x) == -1) {
				max = x;
			}
		}

		System.out.println(max.toString());

		in.close();

	}

}
