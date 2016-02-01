import java.util.HashMap;
import java.util.Scanner;

public class JavaMap {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		int n = Integer.parseInt(in.nextLine());

		for (int i = 0; i < n; i++) {
			String name = in.nextLine();
			String phone = in.nextLine();

			map.put(name, Integer.parseInt(phone));
		}

		while (in.hasNextLine()) {
			String line = in.nextLine().trim();
			if (map.containsKey(line)) {
				System.out.println(line + "=" + map.get(line));
			} else {
				System.out.println("Not found");
			}
		}

		in.close();
	}

}
