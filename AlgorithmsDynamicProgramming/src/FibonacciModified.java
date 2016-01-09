import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long A = in.nextLong();
		long B = in.nextLong();
		int N = in.nextInt();

		BigInteger[] arr = new BigInteger[N];
		arr[0] = BigInteger.valueOf(A);
		arr[1] = BigInteger.valueOf(B);

		for (int i = 2; i < N; i++) {
			arr[i] = arr[i - 1].pow(2).add(arr[i - 2]);
		}

		System.out.println(arr[N - 1]);

		in.close();
	}

}
