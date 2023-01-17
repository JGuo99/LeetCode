package DSF_BFS_Template;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String data;
    List<Node> neighbors;
    public Node(String data) {
        this.data = data;
        this.neighbors = new ArrayList<Node>();
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }
}
