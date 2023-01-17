package DSF_BFS_Template;

import java.util.*;

/*
    Queue (FIFO) - Iterative
    Uses:
        Check if Path Exists between Nodes,
        Finding "hops" or Distance Out or "level" away
    - Goes Wide
 */
public class BFS {
    public static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        Set<Node> seen = new HashSet<>();
        // Start the Search
        queue.add(start);
        while (!queue.isEmpty()) {
            // Pull out the Node in the Stack
            Node curr = queue.poll();
            // Process current Node if NOT seen
            if (!seen.contains(curr)) {
                seen.add(curr);
                System.out.println(curr.data);
            }
            // Add Unseen Children
            for (Node adj : curr.neighbors) {
                if (!seen.contains(adj)) {
                    queue.add(adj);
                }
            }
        }
    }
// Recursive Template ========================================================
    public static void bfs_recursive(Node start) {
        Set<Node> seen = new HashSet<>();
        bfs_recursive(start, seen);
    }

    private static void bfs_recursive(Node curr, Set<Node> seen) {
        if (curr == null) return;
        // Process Current Node if Note Seen
        if (!seen.contains(curr)) {
            seen.add(curr);
            System.out.println(curr.data);
        }
        // Add Unseen Children
        for (Node adj : curr.neighbors) {
            if (!seen.contains(adj)) {
                bfs_recursive(adj, seen);
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

            Recursive - BFS visits the nodes in a breadth-first order and the values are
                printed in the order they are visited. This means that the values are
                printed in the order they are "dequeued" from the queue.

            Iterative - BFS uses a queue to keep track of the nodes to visit, so the
                values are printed in the order they are "enqueued". This means that the
                values are printed in the order they are visited.
         */
        System.out.println("BFS Traversal (Iterative):");
        bfs(a);
        System.out.println("BFS Traversal (Recursive):");
        bfs_recursive(a);
    }
}
