package priorityqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTTraversal {

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (cur == null || !s.isEmpty()) {
            while (cur != null) {
                s.add(cur);
                cur = cur.left;
            }
            cur = s.pop();
            inorder.add(cur.val);
            cur = cur.right;
        }
        return inorder;
    }

    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return inorder;
    }

    private void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
