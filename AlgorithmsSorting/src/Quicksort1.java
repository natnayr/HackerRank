import java.util.Scanner;

public class Quicksort1 {

	static void partition(int[] ar) {
		int p = ar[0];
		int i = 1, j = ar.length - 1;

		while (i <= j) {
			while (ar[i] < p)
				i++;
			while (ar[j] > p)
				j--;

			if (i <= j) {
				swap(ar, i, j);
				i++;
				j--;
			}
		}

		ar = swap(ar, 0, j);
		printArray(ar);
	}

	static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = in.nextInt();
		}
		partition(ar);
	}

	static int[] swap(int[] arr, int i, int j) {
		int e = arr[i];
		arr[i] = arr[j];
		arr[j] = e;
		return arr;
	}
}
