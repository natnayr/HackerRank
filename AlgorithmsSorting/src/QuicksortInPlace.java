import java.util.Scanner;

public class QuicksortInPlace {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		quickSort(arr, 0, arr.length - 1);
	}

	static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int pos = partition(arr, lo, hi);
		print(arr, 0, arr.length - 1);
		quickSort(arr, lo, pos - 1);
		quickSort(arr, pos + 1, hi);

	}

	static int partition(int[] arr, int lo, int hi) {
		int p = arr[hi];

		int i = lo;
		for (int j = lo; j < hi; j++) {
			if (arr[j] <= p) {
				swap(arr, i, j);
				i++;
			}
		}

		swap(arr, i, hi);

		return i;
	}

	static void swap(int[] arr, int i, int j) {
		int e = arr[i];
		arr[i] = arr[j];
		arr[j] = e;
	}

	static void print(int[] arr, int from, int to) {
		for (int i = from; i <= to; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
