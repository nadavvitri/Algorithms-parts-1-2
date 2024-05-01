package part2.directedgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortKhan {
    public int[] topologicalSort(int[][] adj, int v) {
        int[] indegree = new int[v];
        Map<Integer, List<Integer>> nodeToNodes = getAsMap(adj, v, indegree);
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }
        int[] order = new int[v];
        int i = 0;
        while (i < order.length && !q.isEmpty()) {
            int cur = q.poll();
            order[i++] = cur;
            for (int c : nodeToNodes.get(cur)) {
                indegree[c]--;
                if (indegree[c] == 0) {
                    q.add(c);
                    count++;
                }
            }
        }
        return count == order.length ? order : null;
    }

    private Map<Integer, List<Integer>> getAsMap(int[][] adj, int v, int[] indegree) {
        Map<Integer, List<Integer>> nodeToNodes = new HashMap<>();
        for (int i = 0; i < v; i++) {
            nodeToNodes.put(i, new ArrayList<>());
        }

        for (int[] e : adj) {
            int from = e[0];
            int to = e[1];
            nodeToNodes.get(from).add(to);
            indegree[to]++;
        }

        return nodeToNodes;
    }

    public static void main(String[] args) {
        int v = 6;
        int[][] adj = new int[][]{{2, 3}, {3, 1}, {4, 0}, {4, 1}, {5, 0}, {5, 2}};
        TopologicalSortKhan topologicalSortKhan = new TopologicalSortKhan();
        System.out.println(Arrays.toString(topologicalSortKhan.topologicalSort(adj, v)));

        System.out.println(Arrays.toString(topologicalSortKhan.topologicalSort(new int[][]{{0, 1}, {1, 2}, {2, 0}}, 3)));
    }
}
