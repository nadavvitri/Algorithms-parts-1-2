package part2.undirectedgraphs;

public class Diameter {

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return res;
    }

    private int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int ld = diameterOfBinaryTreeHelper(root.left);
        int rd = diameterOfBinaryTreeHelper(root.left);
        res = Math.max(res, ld + rd + 2);
        return Math.max(ld, rd) + 1;
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
