package part2.undirectedgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Center {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> leaves = new ArrayList<>();
        if (edges.length == 0) {
            leaves.add(0);
            return leaves;
        }
        Map<Integer, List<Integer>> nodeToNodes = getNodeToNodes(n, edges);
        int[] degrees = new int[n];
        calcDegrees(nodeToNodes, degrees, leaves);
        int count = leaves.size();
        while (count < n) {
            List<Integer> newLeaves = new ArrayList<>();
            for (int leave : leaves) {
                for (int i : nodeToNodes.get(leave)) {
                    degrees[i]--;
                    if (degrees[i] == 1) {
                        newLeaves.add(i);
                    }
                }
            }
            count += newLeaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    private void calcDegrees(Map<Integer, List<Integer>> nodeToNodes, int[] degrees, List<Integer> leaves) {
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = nodeToNodes.get(i).size();
            if (degrees[i] == 1) {
                leaves.add(i);
            }
        }
    }

    private Map<Integer, List<Integer>> getNodeToNodes(int n, int[][] edges) {
        Map<Integer, List<Integer>> nodeToNodes = init(n);
        for (int[] edge : edges) {
            nodeToNodes.get(edge[0]).add(edge[1]);
            nodeToNodes.get(edge[1]).add(edge[0]);
        }
        return nodeToNodes;
    }

    private Map<Integer, List<Integer>> init(int n) {
        Map<Integer, List<Integer>> nodeToNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeToNodes.put(i, new ArrayList<>());
        }
        return nodeToNodes;
    }

    public class TreeNode {
        int val;
        Diameter.TreeNode left;
        Diameter.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Diameter.TreeNode left, Diameter.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
        List<Integer> minHeightTrees = new Center().findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees);
    }
}
