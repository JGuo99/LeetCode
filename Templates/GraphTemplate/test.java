package GraphTemplate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    @Test
    public void UndriectedCycleDetection() {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 4},
                {1, 5}
        };
        int vertices = edges.length+1;

        UndriectedCycleDetection unDetection = new UndriectedCycleDetection();
        int[][] unResult = unDetection.isCyclic(vertices, edges);
        // ToDo: Still Needs to be fixed!
        assertEquals("[[1,4]]", unResult);
    }

    @Test
    public void DirectedCycleDetection() {
        int[][] edges = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 1},
                {1, 5}
        };
        int vertices = edges.length+1;

        DirectedCycleDetection dirDetection = new DirectedCycleDetection();
        int[][] dirResult = dirDetection.isCyclic(vertices, edges);
        assertEquals("[[4, 1], [3, 4], [2, 3], [1, 2]]", Arrays.deepToString(dirResult));
//        System.out.println(Arrays.deepToString(dirResult));
    }

    @Test
    public void UnionFind() {
        int n = 10;
        UnionFind uf = new UnionFind(n);

        //connecting elements 2 and 3
        uf.union(2, 3);
        //connecting elements 4 and 9
        uf.union(4, 9);
        //checking if element 2 and 4 are connected
        assertEquals(false, uf.connected(2, 4));
        //checking if element 4 and 9 are connected
        assertEquals(true, uf.connected(4, 9));
        //checking the number of disjoint sets
        assertEquals(8, uf.count());
    }

    @Test
    public void Dijkstra() {
        Dijkstra shortest = new Dijkstra();
        int[][] edges = new int[7][3];
        edges[0] = new int[] {0, 1, 10};
        edges[1] = new int[] {0, 2, 3};
        edges[2] = new int[] {1, 3, 2};
        edges[3] = new int[] {2, 1, 4};
        edges[4] = new int[] {2, 3, 8};
        edges[5] = new int[] {2, 4, 2};
        edges[6] = new int[] {3, 4, 5};
        String result = shortest.dijkstra(edges, 6, 0).toString();
        assertEquals("{0=0, 1=7, 2=3, 3=9, 4=5}", result);
        System.out.println(result);
    }

    @Test
    public void DijkstraNode() {
        DijkstraNode shortest = new DijkstraNode();
        final int INF = Integer.MAX_VALUE;
        ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
        int[] dist; // Result of the Shortest Path
        int V = 5;
        int E = 7;
        dist = new int[V];
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
            dist[i] = INF;
        }

        int[][] edges = new int[E][3];
        edges[0] = new int[] {0, 1, 10};
        edges[1] = new int[] {0, 2, 3};
        edges[2] = new int[] {1, 3, 2};
        edges[3] = new int[] {2, 1, 4};
        edges[4] = new int[] {2, 3, 8};
        edges[5] = new int[] {2, 4, 2};
        edges[6] = new int[] {3, 4, 5};
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            adjList.get(src).add(new Node(dest, weight));
            adjList.get(dest).add(new Node(src, weight));
        }
        boolean[] visited = new boolean[V];
        int start = 0;
        shortest.dijkstra(start, dist, visited, adjList);
        int[][] resultList = new int[E][2];
        for (int i = 0; i < V; i++) {
            resultList[i][0] = i;
            resultList[i][1] = dist[i];
            System.out.println("Shortest Path to " + i + " is " + dist[i]);
        }
        String result = Arrays.deepToString(resultList);
        assertEquals("[[0, 0], [1, 7], [2, 3], [3, 9], [4, 5], [0, 0], [0, 0]]",result);
    }
}
