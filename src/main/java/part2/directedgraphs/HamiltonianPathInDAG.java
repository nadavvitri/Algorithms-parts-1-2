package part2.directedgraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HamiltonianPathInDAG {

    public List<Integer> getPath(int n, int[][] edges) {
        Map<Integer, Set<Integer>> nodeToNodes = getAsMap(n, edges);
        List<Integer> order = new ArrayList<>();
        dfs(0, nodeToNodes, order, new HashSet<>());
        for (int i = 0; i < order.size() - 1; i++) {
            int from = order.get(i + 1);
            int to = order.get(i);
            if (!nodeToNodes.get(from).contains(to)) {
                return Collections.emptyList();
            }
        }
        Collections.reverse(order);
        return order;
    }

    private void dfs(int v, Map<Integer, Set<Integer>> nodeToNodes, List<Integer> order, Set<Integer> visited) {
        if (visited.contains(v)) {
            return;
        }
        visited.add(v);
        for (int c : nodeToNodes.get(v)) {
            dfs(c, nodeToNodes, order, visited);
        }
        order.add(v);
    }

    private Map<Integer, Set<Integer>> getAsMap(int n, int[][] edges) {
        Map<Integer, Set<Integer>> nodeToNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeToNodes.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            nodeToNodes.get(edge[0]).add(edge[1]);
        }
        return nodeToNodes;
    }

    public static void main(String[] args) {
        HamiltonianPathInDAG hamiltonianPathInDAG = new HamiltonianPathInDAG();
        int n = 9;
        int[][] edges = {{0, 1}, {0, 3}, {0, 5}, {1, 4}, {1, 2}, {2, 7}, {3, 1}, {3, 4}, {4, 2}, {4, 7},
                {5, 3}, {5, 6}, {5, 8}, {6, 3}, {6, 4}, {6, 7}, {6, 8}, {7, 8}};
        System.out.println(hamiltonianPathInDAG.getPath(n, edges));
    }
}
