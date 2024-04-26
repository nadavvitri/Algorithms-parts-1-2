package part2.directedgraphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReachableVertexDAG {

    public int reachable(int n, int[][] edges) {
        Map<Integer, Set<Integer>> nodeToNodes = getAsMap(n, edges);
        int[] outdegree = new int[n];
        for (int i = 0; i < n; i++) {
            outdegree[i] = nodeToNodes.get(i).size();
        }
        int count = 0;
        int candidate = 0;
        for (int i = 0; i < outdegree.length; i++) {
            if (outdegree[i] == 0) {
                candidate = i;
                count++;
            }
            if (count > 1) {
                return -1;
            }
        }
        return candidate;
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
}
