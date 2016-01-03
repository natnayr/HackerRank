import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CutTheTree {

	public static int[] weight;
	public static int[] hangingWeight;
	public static Node topRoot;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		weight = new int[N];
		hangingWeight = new int[N];

		for (int i = 0; i < N; i++) {
			weight[i] = in.nextInt();
		}

		for (int i = 0; i < N - 1; i++) {
			int root = in.nextInt() - 1;
			if (i == 0) {
				topRoot = new Node(root);
			}

			int child = in.nextInt() - 1;
			treeMap.get(root).add(child);
		}

		buildHangingWeight(topRoot);

		for (int i = 0; i < N; i++) {
			System.out.print(weight[i] + " ");
		}

		System.out.println();

		for (int i = 0; i < N; i++) {
			System.out.print(hangingWeight[i] + " ");
		}

		in.close();

	}

	public static int buildHangingWeight(int node) {

		// find child
		Iterator<Integer> bit = treeMap.get(node).iterator();
		int selfWeight = weight[node];

		while (bit.hasNext()) {
			selfWeight += buildHangingWeight(bit.next());
		}

		// key in
		hangingWeight[node] = selfWeight;
		return selfWeight;
	}
}

class Node {
	private ArrayList<Node> children;
	private int weight;
	private int hangingWeight;

	public Node(int weight) {
		children = new ArrayList<Node>();
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setHangingWeight(int hangingWeight) {
		this.hangingWeight = hangingWeight;
	}

	public int getHangingWeight() {
		return this.hangingWeight;
	}

	public ArrayList<Node> getChildren() {
		return this.children;
	}

	public void addChild(Node child) {
		this.children.add(child);
	}
}