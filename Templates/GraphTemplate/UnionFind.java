package GraphTemplate;
/*
    Connectivity of n vertices.
    Example: https://leetcode.com/problems/redundant-connection/description/
 */
class UnionFind {
    private int[] parent; // Parent Node of Each Vertex
    private int[] rank; // Rank of the Connectivity of Vertex
    private int count; // Quantity of Connectivity

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }
    /*
        Union vertex p and q
        @param p: index of vertex p
        @param q: index of vertex q
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        // If rootP and rootQ are in the same connectivity
        if (rootP == rootQ) return;

        // Keep the depth shallow for optimize efficiency
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
            rank[rootQ] += rank[rootP];
        } else {
            parent[rootQ] = rootP;
            rank[rootP] += rank[rootQ];
        }
        count--; // Quantity of Connectivity
    }

    /*
        Check if vertex p and q are connected in the same component
        @param p: index of vertex p
        @param q: index of vertex q
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /*
        Return the number of disjoint sets
     */
    public int count() {
        return count;
    }
}
