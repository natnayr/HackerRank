import java.util.Scanner;

public class StringsIntroduction {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String aWord = in.next();
		String bWord = in.next();

		System.out.println(aWord.length() + bWord.length());

		if (aWord.compareTo(bWord) > 0) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		System.out.println(((char) (aWord.charAt(0) - 32)) + aWord.substring(1) + " " + ((char) (bWord.charAt(0) - 32))
				+ bWord.substring(1));

		in.close();

	}

}
