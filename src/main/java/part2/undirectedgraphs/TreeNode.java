package part2.undirectedgraphs;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public List<TreeNode> children = new ArrayList<>();

    TreeNode(int val) {
        this.val = val;
    }

    public void addChild(TreeNode node) {
        children.add(node);
    }
}
