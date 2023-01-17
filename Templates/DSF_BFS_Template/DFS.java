package DSF_BFS_Template;

import java.util.*;

/*
    Stack (LIFO) - Either Custom or through Call stack via Recursion
    Uses: Backtracking, Complete Search, Exhausting Possible Paths
    - Goes Deep

    Time: O(|V| + |E|)
    Space: O(|V|)
 */
public class DFS {
    public static void dfs(Node start) {
        Stack<Node> stack = new Stack<>();
        Set<Node> seen = new HashSet<>();
        // Start the Search
        stack.push(start);
        while (!stack.isEmpty()) {
            // Pull out the Node in the Stack
            Node curr = stack.pop();
            // Process current Node if NOT seen
            if (!seen.contains(curr)) {
                seen.add(curr);
                System.out.println(curr.data);
            }
            // Add Unseen Children
            for (Node adj : curr.neighbors) {
                if (!seen.contains(adj)) {
                    stack.push(adj);
                }
            }
        }
    }
// Recursive Template ========================================================
    public static void dfs_recursive(Node start) {
        Set<Node> seen = new HashSet<>();
        dfs_recursive(start, seen);
    }

    private static void dfs_recursive(Node curr, Set<Node> seen) {
        if (curr == null) return;
        // Process Current Node if Note Seen
        if (!seen.contains(curr)) {
            seen.add(curr);
            System.out.println(curr.data);
        }
        // Add Unseen Children
        for (Node adj : curr.neighbors) {
            if (!seen.contains(adj)) {
                dfs_recursive(adj, seen);
            }
        }
    }

    public static void main(String[] args) {
        // Create the graph
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        // Add edges
        a.addNeighbor(b);
        a.addNeighbor(c);
        b.addNeighbor(d);
        b.addNeighbor(e);
        c.addNeighbor(f);
        c.addNeighbor(g);

        /*
            Order in which the nodes are visited and the order in which the
            nodes' values are printed may be different between the two implementations.

            Recursive - DFS visits the nodes in a depth-first order and the values are
                printed in the order they are visited. This means that the values are
                printed in a "pre-order" traversal of the graph.

            Iterative - DFS uses a stack to keep track of the nodes to visit, so the
                values are printed in the opposite order of the order they are visited.
                This means that the values are printed in a "post-order" traversal of the graph.
         */
        System.out.println("DFS Traversal (Iterative):");
        dfs(a);
        System.out.println("DFS Traversal (Recursive):");
        dfs_recursive(a);
    }
}
