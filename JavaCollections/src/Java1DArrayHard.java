import java.util.Scanner;

public class Java1DArrayHard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {

			int N = in.nextInt();
			int M = in.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}

			boolean getThrough = true;
			for (int i = 1; i < N && getThrough == true; i++) {

				// spot a 1
				if (arr[i] == 1) {
					// if a jump goes out
					if (i + M > arr.length) {
						break;
					}

					// try to jump 1
					if (arr[i + M - 1] == 0) {
						// just jump M steps, new position
						i = i + M;
					} else {
						// move back 1 free space till M+1 is free
						i--; // step back
						while (getThrough) {

							if (i < 0 || arr[i] == 1) {
								getThrough = false;
								break;
							}

							if (arr[i + M] == 0) {
								i = i + M;
								break;
							}
							i--;
						}
					}
				}
			}

			if (getThrough) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

			T--;
		}

		in.close();
	}

}
