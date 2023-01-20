package GraphTemplate;
import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        int[][] edges = new int[7][3];
        // a:0, b:1, c:2, d:3, e:4
        edges[0] = new int[] {0, 1, 10};
        edges[1] = new int[] {0, 2, 3};
        edges[2] = new int[] {1, 3, 2};
        edges[3] = new int[] {2, 1, 4};
        edges[4] = new int[] {2, 3, 8};
        edges[5] = new int[] {2, 4, 2};
        edges[6] = new int[] {3, 4, 5};
        System.out.println(dijkstra(edges, 6, 0));
    }

    /*
        Complexity
            - Time: O(E*logV) - From the MinHeap
            - Space: O(V)
        MinHeap (PriorityQueue): <Node>
        Node: <Vertex, Cost>
            - Cost: to reach the Vertex
            - Sort by Cost
        @param edges: 2D Array of edges where...
            - edge[0] = src    (Starting Node)
            - edge[1] = dest   (Ending Node)
            - edge[2] = weight (Weight of the Edge)
        @param n: Number of Nodes (Assuming the Nodes are Integers)
        @param start: starting Node
        @return shortestPath: (Node, TotalWeight)
     */
    public static Map<Integer, Integer> dijkstra(int[][] edges, int n, int start) {
        // Set-Up
        // Create the Map of Nodes
        Map<Integer, List<int[]>> neighbors = new HashMap<>();
        for (int i = 0; i < n; i++) neighbors.computeIfAbsent(i, k -> new ArrayList<>());
        // Add the edges and weight to the Nodes: 0: Src. Node, 1: Dest. Node, 2: Weight
        for (int[] edge : edges) neighbors.get(edge[0]).add(new int[]{edge[1], edge[2]});

        Map<Integer, Integer> shortestPath = new HashMap<>();
        // (Current Node, Weight Cost)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[1] - b[1])
        );
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int node1 = cur[0];
            int weight1 = cur[1];

            if (shortestPath.containsKey(node1)) continue;
            shortestPath.put(node1, weight1);
            for (int[] neighbor : neighbors.get(node1)) {
                int node2 = neighbor[0];
                int weight2 = neighbor[1];
                if (!shortestPath.containsKey(node2)) {
                    pq.add(new int[]{node2, weight1 + weight2});
                }
            }
        }
        return shortestPath;
    }
}