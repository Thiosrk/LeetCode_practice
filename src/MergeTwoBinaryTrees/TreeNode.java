package MergeTwoBinaryTrees;

/**
 * Created by 69401 on 2017/12/28.
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
