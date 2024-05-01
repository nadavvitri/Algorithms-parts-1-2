package part1.priorityqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BSTTraversal {

    public enum Traversal {
        INORDER, PREORDER, POSTORDER
    }

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

    public List<Integer> traversalRecursion(TreeNode root, Traversal traversal) {
        List<Integer> order = new ArrayList<>();
        switch (traversal) {
            case INORDER:
                inorder(root, order);
                break;
            case POSTORDER:
                postOrder(root, order);
                break;
            case PREORDER:
                preOrder(root, order);
        }
        return order;
    }

    private void inorder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }

    private void preOrder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        inorder.add(root.val);
        inorder(root.left, inorder);
        inorder(root.right, inorder);
    }

    private void postOrder(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return;
        }
        inorder.add(root.val);
        inorder(root.left, inorder);
        inorder(root.right, inorder);
    }

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, null, new TreeNode(6));
        TreeNode root = new TreeNode(1, left, right);

        BSTTraversal bstTraversal = new BSTTraversal();
        for (Traversal traversal : Traversal.values()) {
            System.out.println(traversal);
            System.out.println(bstTraversal.traversalRecursion(root, traversal));
        }
    }
}
