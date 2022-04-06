/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int left=0;
        int right=n-1;

        while(left<=right){
            int mid=(left+right)/2;
            if(target==nums[mid]){
                return mid;
            }
            if (target<nums[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return -1;

        
    }
}
// @lc code=end

