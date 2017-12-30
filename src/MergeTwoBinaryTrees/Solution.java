package MergeTwoBinaryTrees;

/**
 * Created by 69401 on 2017/12/28.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Solution {

    /**
     * 1.Description:Given two binary trees and imagine that when you put one of them to cover the other,
     * some nodes of the two trees are overlapped while the others are not.
     * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
     * then sum node values up as the new value of the merged node. Otherwise,
     * the NOT null node will be used as the node of new tree.
     *
     * Example 1:
     *Input:
     *Tree 1                     Tree 2
     *     1                         2
         / \                       / \
       3   2                     1   3
      /                           \   \
     5                             4   7
     Output:
     Merged tree:
            3
          / \
        4   5
      / \   \
     5   4   7


     *2.Note: The merging process must start from the root nodes of both trees.
     */


    //LeetCode Runtime: 14 ms
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        TreeNode res;

        if (t1 == null && t2 ==null){
            return null;
        }
        else{
            if (t1 == null) {
                res = t2;
            }else if (t2 == null){
                res = t1;
            }else {
                res = new TreeNode(t1.val + t2.val);
                res.left = mergeTrees(t1.left,t2.left);
                res.right = mergeTrees(t1.right,t2.right);
            }
            return res;
        }

    }

    /**
     * Better Answer:
     * public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
     *if(t1 == null)
     *return t2;

     *if(t2 == null)
     *return t1;

     *TreeNode node = new TreeNode(t1.val + t2.val);
     *node.left = mergeTrees(t1.left, t2.left);
     *node.right = mergeTrees(t1.right, t2.right);
     *return node;
     *}
     */

    /**
     * 分析：对树的操作一般都使用递归方法。
     */

}
