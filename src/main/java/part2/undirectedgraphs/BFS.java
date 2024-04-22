package part2.undirectedgraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public BFS(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            System.out.println(cur.val);
            visited.add(cur);
            for (TreeNode c : cur.children) {
                if (!visited.contains(c)) {
                    q.add(c);
                }
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
        new BFS(root);
    }
}
