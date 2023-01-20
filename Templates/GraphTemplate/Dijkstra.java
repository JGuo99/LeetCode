package GraphTemplate;
import java.util.*;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;
    static int V, E;
    static int start;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        V = sc.nextInt();
//        E = sc.nextInt();
        V = 5;
        E = 4;
        dist = new int[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adjList.get(u).add(new Node(v, w));
            adjList.get(v).add(new Node(u, w));
        }

        start = sc.nextInt();
        dijkstra(start);

        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curDist = cur.dist;
            int curNode = cur.node;

            if (visited[curNode]) {
                continue;
            }
            visited[curNode] = true;

            for (Node n : adjList.get(curNode)) {
                if (dist[n.node] > curDist + n.dist) {
                    dist[n.node] = curDist + n.dist;
                    pq.offer(new Node(n.node, dist[n.node]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int node;
    int dist;

    public Node(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int compareTo(Node n) {
        return dist - n.dist;
    }
}
