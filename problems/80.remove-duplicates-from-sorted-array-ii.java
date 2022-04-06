/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        int n=nums.length;
        int cnt=1;

        if(n==0){
            return 0;
        }

        while(right<n){
            if(nums[left]==nums[right] &&cnt==0){
                right++;
            }
            else{
                if (nums[left]==nums[right]){
                    cnt--;
                }
                else{
                    cnt=1;
                }
                nums[++left]=nums[right++];
            }

        }

        return left+1;


    }
}
// @lc code=end

