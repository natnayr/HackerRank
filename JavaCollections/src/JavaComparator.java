import java.util.Scanner;

public class JavaComparator {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		String[] arrNames = new String[N];
		int[] arrScore = new int[N];

		for (int i = 0; i < N; i++) {
			arrNames[i] = in.next();
			arrScore[i] = in.nextInt();
		}

		// sort
		for (int i = 1; i < N; i++) {
			if (arrScore[i - 1] < arrScore[i]) {
				for (int j = i; j > 0; j--) {
					if (arrScore[j - 1] < arrScore[j]) {
						swap(arrNames, arrScore, j - 1, j);
					} else if (arrScore[j - 1] == arrScore[j] && arrNames[j - 1].compareTo(arrNames[j]) < 0) {
						swap(arrNames, arrScore, j - 1, j);
					}
				}
			} else if (arrScore[i - 1] == arrScore[i] && arrNames[i - 1].compareTo(arrNames[i]) < 0) {
				swap(arrNames, arrScore, i - 1, i);
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.println(arrNames[i] + " " + arrScore[i]);
		}

		in.close();

	}

	public static void swap(String[] arrNames, int[] arrScore, int i, int j) {
		String tempName = arrNames[i];
		arrNames[i] = arrNames[j];
		arrNames[j] = tempName;

		int tempScore = arrScore[i];
		arrScore[i] = arrScore[j];
		arrScore[j] = tempScore;

	}

}
