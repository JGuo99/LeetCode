package GraphTemplate;
import java.util.*;

public class DijkstraNode {
    /*
        Input Format:
            - NumVert NumEdges
            - Src Dest Weight
            - Start Vert
        Example:
            5 7
            0 1 10
            0 2 3
            1 3 2
            2 1 4
            2 3 8
            2 4 2
            3 4 5
            0
        Output Format: (0 - n) (Shortest Path)
     */
    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE;
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
        int[] dist;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = sc.nextInt();

        dist = new int[V];
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            System.out.print("Enter edge " + (i+1) + " in the format of Src Dest Weight: ");
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            adjList.get(src).add(new Node(dest, weight));
            adjList.get(dest).add(new Node(src, weight));
        }

        System.out.print("Enter the starting vertex: ");
        int start = sc.nextInt();
        boolean[] visited = new boolean[V];
        dijkstra(start, dist, visited, adjList);

        // Output Format
        System.out.println("Starting From " + start);
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest Path to " + i + " is " + dist[i]);
        }
    }

    public static void dijkstra(int start, int[] dist, boolean[] visited, List<ArrayList<Node>> neighbors) {
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

            for (Node n : neighbors.get(curNode)) {
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
