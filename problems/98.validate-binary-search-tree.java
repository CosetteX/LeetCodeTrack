/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 中序遍历二叉树可以得到有序数列
    // 中序遍历：左根右
    double last=-Double.MAX_VALUE;


    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }

        if(isValidBST(root.left)){
            if (last<root.val){
                last=root.val;
                return isValidBST(root.right);
            }
            
        }
        return false;
    }
}
// @lc code=end

