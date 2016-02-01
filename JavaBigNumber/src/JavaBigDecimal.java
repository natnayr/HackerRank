import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class JavaBigDecimal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		ArrayList<BigDecimal> arr = new ArrayList<BigDecimal>();
		String[] stringDeci = new String[n];

		for (int i = 0; i < n; i++) {
			String line = in.next();
			arr.add(new BigDecimal(line));
			stringDeci[i] = line;
		}

		int i = 1;
		while (i < n) {

			if (arr.get(i - 1).compareTo(arr.get(i)) < 0) {
				for (int j = i; j > 0; j--) {
					if (arr.get(j - 1).compareTo(arr.get(j)) < 0) {
						swap(j - 1, j, arr, stringDeci);
					} else {
						break;
					}
				}
			}

			i++;
		}

		for (i = 0; i < stringDeci.length; i++) {
			System.out.println(stringDeci[i]);
		}

		in.close();
	}

	public static void swap(int i, int j, ArrayList<BigDecimal> arr, String[] stringDeci) {
		BigDecimal tempDeci = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, tempDeci);

		String tempStr = stringDeci[i];
		stringDeci[i] = stringDeci[j];
		stringDeci[j] = tempStr;
	}
}
