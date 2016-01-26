import java.util.Scanner;

public class MaximizingXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int L = in.nextInt();
		int R = in.nextInt();

		int max = 0;
		for (int i = L; i <= R; i++) {
			for (int j = L; j <= R; j++) {
				int xor = (i ^ j);
				if (xor > max) {
					max = xor;
				}
			}
		}

		System.out.println(max);

		in.close();

	}

}
