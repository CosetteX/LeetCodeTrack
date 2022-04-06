/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[left]=nums[i];
                left++;
            }
        }

        while(left<n){
            nums[left++]=0;
        }
        
    }
}
// @lc code=end

