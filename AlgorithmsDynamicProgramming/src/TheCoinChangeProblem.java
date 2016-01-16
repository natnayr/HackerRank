import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class TheCoinChangeProblem {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int C = in.nextInt();

		long[] arr = new long[C];

		for (int i = 0; i < C; i++) {
			arr[i] = in.nextLong();
		}

		Arrays.sort(arr);
		HashMap<AmountDenom, Integer> numberOfWays = new HashMap<AmountDenom, Integer>();

		System.out.println(findPermutations(N, arr, numberOfWays));

		in.close();

	}

	public static long findPermutations(long amountLeft, long[] arr, HashMap<AmountDenom, Integer> numberOfWays) {

		if (amountLeft == 0) {
			return 1;
		} else if (amountLeft < 0) {
			return 0;
		}

		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += findPermutations(amountLeft - arr[i], arr, numberOfWays);
		}

		return result;
	}

}

class AmountDenom {

	int amount;
	int denom;

	public AmountDenom(int amount, int denom) {
		this.amount = amount;
		this.denom = denom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.amount, this.denom);
	}

	public boolean equals(Object obj) {
		if (obj instanceof AmountDenom) {
			AmountDenom keyObj = (AmountDenom) obj;
			return (keyObj.amount == this.amount && keyObj.denom == this.denom);
		} else {
			return false;
		}
	}
}