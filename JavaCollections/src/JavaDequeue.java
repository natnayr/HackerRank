import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class JavaDequeue {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		Deque dq = new LinkedList<Integer>();
		int arr[] = new int[10000001];
		int count = 0;
		int max = 0;

		for (int i = 0; i < M; i++) {
			int num = in.nextInt();

			if (arr[num] == 0) {
				count++;
				max = Math.max(max, count);
			}
			arr[num]++;
			dq.addLast(num);
		}

		for (int i = M; i < N; i++) {
			int x = (int) dq.removeFirst();
			if (arr[x] == 1)
				count--;
			arr[x]--;

			int num = in.nextInt();
			if (arr[num] == 0)
				count++;
			arr[num]++;
			dq.addLast(num);
			max = Math.max(max, count);
		}

		System.out.println(max);

		in.close();
	}

}
