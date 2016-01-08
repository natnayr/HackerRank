import java.util.LinkedList;
import java.util.Scanner;

public class SnakesAndLaddersTheQuickestWayUp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while (T > 0) {

			Vertex[] vertexList = new Vertex[100];
			// init Dijkstra's Map
			for (int i = 0; i < 100; i++) {
				vertexList[i] = new Vertex(i + 1);
				if (i > 0) {
					vertexList[i].adjEdge.add(new Edge(vertexList[i - 1], 1));
				}
			}

			T--;
		}
		in.close();
	}
}

class Vertex {
	public int squareNum;
	public LinkedList<Edge> adjEdge;
	public Vertex previous;
	public int maxDistance = 1;

	public Vertex(int squareNum) {
		adjEdge = new LinkedList<Edge>();
		this.squareNum = squareNum;
	}
}

class Edge {
	public Vertex target;
	public int dist;

	public Edge(Vertex target, int dist) {
		this.target = target;
		this.dist = dist;
	}

}