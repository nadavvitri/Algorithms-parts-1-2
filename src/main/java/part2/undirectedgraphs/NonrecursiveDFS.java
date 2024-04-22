package part2.undirectedgraphs;

import java.util.HashSet;
import java.util.Stack;

public class NonrecursiveDFS {

    public NonrecursiveDFS(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        s.add(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            visited.add(cur);
            System.out.println(cur.val);
            for (TreeNode c : cur.children) {
                if (!visited.contains(c)) {
                    s.add(c);
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
        new NonrecursiveDFS(root);
    }
}
