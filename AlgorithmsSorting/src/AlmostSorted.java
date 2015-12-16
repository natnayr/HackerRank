

import java.util.ArrayList;
import java.util.Scanner;

public class AlmostSorted {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt() + 2; // Add first and last item as 0 & 1000000
		int[] arr = new int[N];

		ArrayList<Integer> upList = new ArrayList<Integer>();
		ArrayList<Integer> dipList = new ArrayList<Integer>();

		arr[0] = 0;
		for (int i = 1; i < N - 1; i++) {
			arr[i] = in.nextInt();
		}
		arr[N - 1] = 1000000;

		int dip = 0;
		int up = 0;

		// run through 1 to N-2, leave first and last
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
				up++;
				upList.add(i);
			} else if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
				dip++;
				dipList.add(i);
			}
		}

		System.out.println("up: " + up);
		System.out.println("dip: " + dip);

		// reverse first
		if (up == 1 && dip == 1) {
			System.out.println("yes");
			System.out.println("reverse " + upList.get(0) + " "
					+ dipList.get(0));
		} else if (up == 2 && dip == 2) {
			System.out.println("yes");
			System.out.println("swap " + upList.get(0) + " " + dipList.get(1));
		} else {
			System.out.println("no");
		}

	}

	public static boolean reverseNCheck(int[] arr, int start, int end) {

	}

	public static boolean swapNCheck(int[] arr, int i, int j) {

	}

	public static boolean check(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}
		return true;
	}
}
