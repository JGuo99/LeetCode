package GraphTemplate;

import java.util.*;

public class DirectedCycleDetection {
    /*
    Using DFS - List out all the edges that froms the cycle
 */
    private List<int[]> cycleEdges = new ArrayList<>();
    public int[][] isCyclic(int vertices, int[][] edges) {

        Map<Integer, List<Integer>> edgesMap = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            edgesMap.computeIfAbsent(i, k -> new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            edgesMap.get(edges[i][0]).add(edges[i][1]);
        }
        int vert = 0;
        while (vert < vertices) {
            if (dfs(vert, new HashSet<>(), edgesMap)) return cycleEdges.toArray(new int[cycleEdges.size()][]);
            vert++;
        }
        return new int[][]{};
    }

    private boolean dfs(
            int vertex,
            Set<Integer> seen,
            Map<Integer, List<Integer>> edges
    ) {
        if (seen.contains(vertex)) return true; // Cycle Found
        if (edges.get(vertex).isEmpty()) return false;

        seen.add(vertex);
        for (int vert : edges.get(vertex)) {
            if (dfs(vert, seen, edges)) {
                cycleEdges.add(new int[] {vertex, vert});
                return true;
            }
        }
        seen.remove(vertex);
        edges.put(vertex, new ArrayList<>());
        return false;
    }
}
