import java.util.HashSet;
import java.util.Scanner;

public class JavaHashSet {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = Integer.parseInt(in.nextLine());
		HashSet<String> set = new HashSet<String>();

		while (N > 0) {
			String line = in.nextLine().trim();
			if (!line.equals("")) {
				set.add(line);
				System.out.println(set.size());
			}
			N--;
		}

		in.close();
	}

}
