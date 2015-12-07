import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TheFullCountingSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int halfT = T / 2;

		ArrayList<LinkedList<String>> map = new ArrayList<LinkedList<String>>();
		for (int i = 0; i < 100; i++) {
			map.add(new LinkedList<String>());
		}

		while (T > 0) {

			int num = in.nextInt();
			String word = in.next().trim();

			if (halfT > 0) {
				map.get(num).add("-");
				halfT--;
			} else {
				map.get(num).add(word);
			}
			T--;
		}

		StringBuilder sb = new StringBuilder();
		Iterator<LinkedList<String>> vit = map.iterator();
		while (vit.hasNext()) {
			LinkedList<String> it = vit.next();
			for (String word : it) {
				sb.append(word + " ");
			}
		}
		System.out.println(sb.toString().trim());
	}
}
