import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class MissingNumbers {

	public static void main(String[] args) {

		HashMap<Integer, Integer> hmListA = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hmListB = new HashMap<Integer, Integer>();

		Scanner in = new Scanner(System.in);

		int NA = in.nextInt();
		for (int i = 0; i < NA; i++) {
			int num = in.nextInt();
			int count = hmListA.containsKey(num) ? hmListA.get(num) : 0;
			hmListA.put(num, count + 1);
		}

		int NB = in.nextInt();
		for (int i = 0; i < NB; i++) {
			int num = in.nextInt();
			int count = hmListB.containsKey(num) ? hmListB.get(num) : 0;
			hmListB.put(num, count + 1);
		}

		TreeSet<Integer> sortedSet = new TreeSet<Integer>();

		Iterator<Integer> hmbit = hmListB.keySet().iterator();
		while (hmbit.hasNext()) {
			int bNum = hmbit.next();
			if (hmListA.containsKey(bNum) == false) {
				sortedSet.add(bNum);
			} else {
				if (hmListA.get(bNum) < hmListB.get(bNum)) {
					sortedSet.add(bNum);
				}
			}
		}

		for (int item : sortedSet) {
			System.out.print(item + " ");
		}
	}
}
