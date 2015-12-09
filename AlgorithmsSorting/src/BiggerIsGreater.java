import java.util.Scanner;

public class BiggerIsGreater {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T > 0) {

			String wordIn = in.next();
			char[] word = new char[wordIn.length()];

			for (int i = 0; i < wordIn.length(); i++) {
				word[i] = wordIn.charAt(i);
			}

			nextPermutation(word);
			T--;
		}
	}

	// sort all letters left of
	static void quickSort(char[] word, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int p = partition(word, lo, hi);
		quickSort(word, lo, p - 1);
		quickSort(word, p + 1, hi);
	}

	static int partition(char[] word, int lo, int hi) {
		int pivot = word[hi];
		int i = lo;
		for (int j = lo; j < hi; j++) {
			if (word[j] <= pivot) {
				swap(word, i, j);
				i++;
			}
		}
		swap(word, hi, i);
		return i;
	}

	public static void nextPermutation(char[] word) {

		// Find the right most char which is smaller than the next.
		int i;
		for (i = word.length - 2; i >= 0; --i) {
			if (word[i] < word[i + 1])
				break;
		}

		if (i == -1) {
			System.out.println("no answer");
			return;
		} else {
			int ceilIndex = findNextSmallestCell(word, word[i], i + 1,
					word.length - 1);
			swap(word, ceilIndex, i);
			quickSort(word, i, word.length - 1);
			print(word);
		}

	}

	// find index of smallest char but greater than 'first' withing lo-hi
	static int findNextSmallestCell(char[] word, char first, int lo, int hi) {

		int cellIndex = lo;
		for (int i = lo + 1; i <= hi; i++) {
			if (first < word[i] && word[i] < word[cellIndex]) {
				cellIndex = i;
			}
		}

		return cellIndex;
	}

	static void swap(char[] word, int i, int j) {
		char k = word[i];
		word[i] = word[j];
		word[j] = k;
	}

	static void print(char[] word) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < word.length; i++) {
			sb.append(word[i]);
		}
		System.out.println(sb.toString().trim());
	}
}
