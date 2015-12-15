import java.util.LinkedList;
import java.util.Scanner;

public class SherlockAndWatson {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		// no. of operations
		int K = in.nextInt();

		// no. of queries
		int Q = in.nextInt();

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(in.nextInt());
		}

		for (int i = 0; i < (K % N); i++) {
			int num = list.pollLast();
			list.addFirst(num);
		}

		for (int i = 0; i < Q; i++) {
			int query = in.nextInt();
			System.out.println(list.get(query));
		}
	}
}
