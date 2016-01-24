import java.util.Scanner;

public class JimAndTheOrders {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Order[] arr = new Order[N];

		for (int i = 0; i < N; i++) {

			int t = in.nextInt();
			int d = in.nextInt();
			arr[i] = new Order(i + 1, t + d);
		}

		for (int i = 1; i < N; i++) {
			for (int j = i; j > 0 && arr[j].totalTime < arr[j - 1].totalTime; j--) {
				Order cur = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = cur;
			}
		}

		for (int i = 0; i < N; i++) {
			System.out.print(arr[i].nthOrder + " ");
		}

		in.close();
	}

	static class Order {

		public int nthOrder;
		public int totalTime;

		public Order(int nthOrder, int totalTime) {
			this.nthOrder = nthOrder;
			this.totalTime = totalTime;
		}
	}

}
