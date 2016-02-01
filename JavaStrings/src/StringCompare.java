import java.util.Scanner;

public class StringCompare {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String word = in.next();
		int n = in.nextInt();

		String minWord = word.substring(0, n);
		String maxWord = word.substring(0, n);

		for (int i = 0; i <= word.length() - n; i++) {
			String cur = word.substring(i, i + n);
			if (minWord.compareTo(cur) > 0)
				minWord = cur;

			if (maxWord.compareTo(cur) < 0)
				maxWord = cur;
		}

		System.out.println(minWord);
		System.out.println(maxWord);

		in.close();
	}

}
