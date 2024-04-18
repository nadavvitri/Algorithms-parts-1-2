package part1.priorityqueues;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);

    }

    private boolean isValidBST(TreeNode root, Integer left, Integer right) {
        if (root == null) {
            return true;
        }
        if ((left != null && root.val <= left) || (right != null && root.val >= right)) {
            return false;
        }
        return isValidBST(root.left, left, root.val) && isValidBST(root.right, root.val, right);
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
