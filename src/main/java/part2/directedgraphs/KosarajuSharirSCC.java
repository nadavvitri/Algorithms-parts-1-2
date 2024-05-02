package part2.directedgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KosarajuSharirSCC {

    int count = 0;
    private final int[] scc;
    private final int[][] adj;
    private final int n;

    public KosarajuSharirSCC(int n, int[][] adj) {
        this.scc = new int[n];
        this.adj = adj;
        this.n = n;
    }

    private int[] getScc() {
        Map<Integer, List<Integer>> nodeToNodes = getAsMap(adj, n);
        List<Integer> postOrder = getPostOrder();
        boolean[] visited = new boolean[n];
        for (int i = postOrder.size() - 1; i >= 0; i--) {
            int v = postOrder.get(i);
            if (!visited[v]) {
                dfs(v, nodeToNodes, visited);
                count++;
            }
        }
        return scc;
    }

    private void dfs(int v, Map<Integer, List<Integer>> nodeToNodes, boolean[] visited) {
        visited[v] = true;
        scc[v] = count;
        for (int u : nodeToNodes.get(v)) {
            if (!visited[u]) {
                dfs(u, nodeToNodes, visited);
            }
        }
    }

    private List<Integer> getPostOrder() {
        Map<Integer, List<Integer>> nodeToNodes = getAsMap(reverse(adj), n);
        List<Integer> postOrder = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int v = 0; v < n; v++) {
            dfs(v, postOrder, visited, nodeToNodes);
        }
        return postOrder;
    }

    private void dfs(int v, List<Integer> postOrder, boolean[] visited, Map<Integer, List<Integer>> nodeToNodes) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int u : nodeToNodes.get(v)) {
            dfs(u, postOrder, visited, nodeToNodes);
        }
        postOrder.add(v);
    }

    private int[][] reverse(int[][] adj) {
        int[][] reversed = new int[adj.length][adj[0].length];
        for (int i = 0; i < adj.length; i++) {
            int[] e = adj[i];
            reversed[i] = new int[]{e[1], e[0]};
        }
        return reversed;
    }

    private Map<Integer, List<Integer>> getAsMap(int[][] adj, int v) {
        Map<Integer, List<Integer>> nodeToNodes = new HashMap<>();
        for (int i = 0; i < v; i++) {
            nodeToNodes.put(i, new ArrayList<>());
        }

        for (int[] e : adj) {
            int from = e[0];
            int to = e[1];
            nodeToNodes.get(from).add(to);
        }

        return nodeToNodes;
    }

    public static void main(String[] args) {
        int n = 13;
        int[][] adj = new int[][]{
                {4, 2},
                {2, 3},
                {3, 2},
                {6, 0},
                {0, 1},
                {2, 0},
                {11, 12},
                {12, 9},
                {9, 10},
                {9, 11},
                {7, 9},
                {10, 12},
                {11, 4},
                {4, 3},
                {3, 5},
                {6, 8},
                {8, 6},
                {5, 4},
                {0, 5},
                {6, 4},
                {6, 9},
                {7, 6}
        };
        KosarajuSharirSCC kosarajuSharirSCC = new KosarajuSharirSCC(n, adj);
        int[] scc = kosarajuSharirSCC.getScc();
        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < scc.length; i++) {
            components.putIfAbsent(scc[i], new ArrayList<>());
            components.get(scc[i]).add(i);
        }
        for (Map.Entry<Integer, List<Integer>> entry : components.entrySet()) {
            System.out.println("Component " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
