import java.util.Scanner;

public class JimAndTheOrders {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Order[] arr = new Order[N];

		for (int i = 0; i < N; i++) {

			int t = in.nextInt();
			int d = in.nextInt();
			arr[i].nthOrder = i + 1;
			arr[i].totalTime = t + d;
		}

		in.close();
	}

	class Order {

		public int nthOrder;
		public int totalTime;

		public Order(int nthOrder, int totalTime) {
			this.nthOrder = nthOrder;
			this.totalTime = totalTime;
		}
	}

}
