import java.util.Scanner;

public class FlippingBits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int T = in.nextInt();

		while (T > 0) {

			long num = in.nextLong();

			long maxInt = (long) Math.pow(2, 32) - 1;
			System.out.println(maxInt - num);

			T--;
		}

		in.close();

	}

}
