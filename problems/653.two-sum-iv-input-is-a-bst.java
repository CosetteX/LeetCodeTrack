import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=653 lang=java
 *
 * [653] Two Sum IV - Input is a BST
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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        List<Integer> list=new ArrayList<Integer>();

        inOrder(root, list);
        
        int i = 0, j = list.size() - 1;
        while (i < j) {

            int a=list.get(i);
            int b=list.get(j);
            int sum = a+b;
            if (sum == k) return true;
            if (sum < k) {
                i++;
            }
            else {
                j--;
            }
        }
        
        return false;

    }
    private void inOrder(TreeNode root, List<Integer> list){
        if (root==null){
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
// @lc code=end

