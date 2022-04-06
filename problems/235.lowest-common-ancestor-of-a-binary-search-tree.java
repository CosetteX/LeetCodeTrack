/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;  
         }
            
         while(root != null){
             if(p.val < root.val && q.val < root.val){
                 root = root.left;//变换当前节点，向下遍历
             }else if(p.val > root.val && q.val >root.val){
                 root = root.right;
             }else{
                 return root;
             }
         }
          return root;
    }
}
// @lc code=end

