import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CutTheTree {

	public static int[] weight;
	public static long[] hangingWeight;
	public static Node topRoot;
	public static ArrayList<Node> nodeList;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		weight = new int[N];
		hangingWeight = new long[N];
		nodeList = new ArrayList<Node>();
		boolean[] visited = new boolean[N];
		ArrayList<LeftRight> pairList = new ArrayList<LeftRight>();
		long totalWeight = 0;

		// weight and nodeList init
		for (int i = 0; i < N; i++) {
			weight[i] = in.nextInt();
			totalWeight += weight[i];

			nodeList.add(new Node(weight[i], i));
			visited[i] = false;
		}

		// paring of connections (undirected)
		for (int i = 0; i < N - 1; i++) {
			int parent = in.nextInt() - 1;
			int child = in.nextInt() - 1;

			pairList.add(new LeftRight(parent, child));
			// undirected so dual way
			nodeList.get(parent).addChild(nodeList.get(child));
			nodeList.get(child).addChild(nodeList.get(parent));

			if (i == 0) {
				topRoot = nodeList.get(parent);
			}
		}

		dfs(topRoot, visited);

		long smallestTreeDiff = 1000000000;
		// Calculate every treeDiff and find the smallest
		Iterator<LeftRight> pit = pairList.iterator();
		while (pit.hasNext()) {
			LeftRight curPair = pit.next();
			long smallerTreeWeight = Math.min(hangingWeight[curPair.left],
					hangingWeight[curPair.right]);
			long restWeight = totalWeight - smallerTreeWeight;

			long treeDiff = Math.abs(restWeight - smallerTreeWeight);
			smallestTreeDiff = Math.min(smallestTreeDiff, treeDiff);
		}

		System.out.println(smallestTreeDiff);

		in.close();
	}

	public static long dfs(Node root, boolean[] visited) {
		if (root == null) {
			return 0;
		}

		long total = root.getWeight();
		visited[root.getIndex()] = true;

		if (!root.getChildren().isEmpty() && root.getChildren() != null) {
			for (Node child : root.getChildren()) {
				if (!visited[child.getIndex()]) {
					total += dfs(child, visited);
				}
			}
		}

		root.setHangingWeight(total);
		hangingWeight[root.getIndex()] = total;
		return root.getHangingWeight();
	}
}

class LeftRight {
	public int left;
	public int right;

	public LeftRight(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

class Node {
	private ArrayList<Node> children;
	private long weight;
	private long hangingWeight;
	private int index;

	public Node(int weight, int index) {
		children = new ArrayList<Node>();
		this.weight = weight;
		this.index = index;
	}

	public int getIndex() {
		return this.index;
	}

	public long getWeight() {
		return weight;
	}

	public void setHangingWeight(long hangingWeight) {
		this.hangingWeight = hangingWeight;
	}

	public long getHangingWeight() {
		return this.hangingWeight;
	}

	public ArrayList<Node> getChildren() {
		return this.children;
	}

	public void addChild(Node child) {
		this.children.add(child);
	}
}