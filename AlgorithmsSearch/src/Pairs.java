import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = in.nextInt();
			map.put(arr[i], 0);
		}

		for (int i = 0; i < N; i++) {
			int newVal1 = arr[i] - K;
			int newVal2 = arr[i] + K;

			if (map.containsKey(newVal1) && newVal1 > 0) {
				map.put(newVal1, map.get(newVal1) + 1);
			}

			if (map.containsKey(newVal2) && newVal2 > 0) {
				map.put(newVal2, map.get(newVal2) + 1);
			}
		}

		int count = 0;
		Iterator<Integer> it = map.values().iterator();
		while (it.hasNext()) {
			int pairCount = it.next();
			if (pairCount > 0) {
				count += pairCount;
			}
		}

		System.out.println(count / 2);
	}
}
