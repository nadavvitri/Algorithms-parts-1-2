package part2.undirectedgraphs;


import java.util.HashSet;

public class DepthFirstSearch {
    public DepthFirstSearch(TreeNode root) {
        HashSet<TreeNode> visited = new HashSet<>();
        dfs(root, visited);
    }

    private void dfs(TreeNode root, HashSet<TreeNode> visited) {
        System.out.println(root.val);
        visited.add(root);
        for (TreeNode c : root.children) {
            if (!visited.contains(c)) {
                dfs(c, visited);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.addChild(left);
        root.addChild(right);

        left.addChild(new TreeNode(3));
        left.addChild(new TreeNode(4));
        left.addChild(new TreeNode(5));

        right.addChild(new TreeNode(6));
        right.addChild(new TreeNode(7));
        new DepthFirstSearch(root);
    }
}
