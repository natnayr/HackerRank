import java.util.ArrayList;
import java.util.Scanner;

public class Quicksort2 {

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
		quickSort(arr, lo, pos - 1);
		quickSort(arr, pos + 1, hi);
		print(arr, lo, hi);
	}

	static int partition(int[] arr, int lo, int hi) {
		int p = arr[lo];
		ArrayList<Integer> leftList = new ArrayList<Integer>();
		ArrayList<Integer> rightList = new ArrayList<Integer>();

		for (int i = lo + 1; i <= hi; i++) {
			if (arr[i] > p) {
				rightList.add(arr[i]);
			} else {
				leftList.add(arr[i]);
			}
		}

		copyOver(leftList, arr, lo);
		int ppos = leftList.size() + lo;
		arr[ppos] = p;
		copyOver(rightList, arr, ppos + 1);

		return lo + leftList.size();
	}

	static void copyOver(ArrayList<Integer> list, int[] arr, int start) {
		for (int num : list) {
			arr[start++] = num;
		}
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
