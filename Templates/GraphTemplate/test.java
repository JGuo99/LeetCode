package GraphTemplate;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

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
}
