package part2.directedgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostOrderDFS {

    private List<Integer> topologicalSort(int[][] adj, int v) {
        Map<Integer, List<Integer>> nodeToNodes = getAsMap(adj, v);
        List<Integer> order = new ArrayList<>();
        boolean[] visited = new boolean[v];
        boolean[] done = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (cycle(i, nodeToNodes, visited, done, order)) {
                return null;
            }
        }
        return order;
    }

    private boolean cycle(int v, Map<Integer, List<Integer>> nodeToNodes, boolean[] path, boolean[] done, List<Integer> order) {
        if (done[v]) {
            return false;
        }
        if (path[v]) {
            return true;
        }
        path[v] = true;
        for (int nei : nodeToNodes.get(v)) {
            if (cycle(nei, nodeToNodes, path, done, order)) {
                return true;
            }
        }
        path[v] = false;
        order.add(v);
        done[v] = true;
        return false;
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
        int v = 6;
        int[][] adj = new int[][]{{2, 3}, {3, 1}, {4, 0}, {4, 1}, {5, 0}, {5, 2}};
        PostOrderDFS postOrderDFS = new PostOrderDFS();

        System.out.println(postOrderDFS.topologicalSort(adj, v));

        System.out.println(postOrderDFS.topologicalSort(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3));
    }
}
