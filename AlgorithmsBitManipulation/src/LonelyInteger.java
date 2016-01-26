import java.util.Scanner;

public class LonelyInteger {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		boolean[] arr = new boolean[100];
		int N = in.nextInt();

		for (int i = 0; i < 100; i++) {
			arr[i] = false;
		}

		for (int i = 0; i < N; i++) {
			int idx = in.nextInt();
			arr[idx] ^= true;
		}

		for (int i = 0; i < 100; i++) {
			if (arr[i] == true) {
				System.out.println(i);
				break;
			}
		}

		in.close();

	}

}
