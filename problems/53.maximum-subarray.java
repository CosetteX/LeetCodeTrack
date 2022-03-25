/*
 * @lc app=leetcode id=53 lang=java
 *
 * [53] Maximum Subarray
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;

        if (n==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        else if (nums.length==2){
            if (nums[0]>=0&&nums[1]>=0){
                return (nums[0]+nums[1]);
            }
            else{
                return Math.max(nums[0],nums[1]);
            }
        }
        
        int dp_pre=nums[0];
        int dp_i=0;
        int res=dp_pre;

        // 为什么使用dp_pre 和dp_i，而不是整个dp数组？
        // 状态压缩：dp_i的值只与dp_i-1有关
        // 这样子能减小空间复杂度

     
        // 可以认为这个问题转化成了：
        // 比较nums的n-1个子数组的n-1个最大子数组和的最大值
        // 每个子数组从nums[0]开始
        for (int i=1;i<n;i++){
            dp_i = Math.max(dp_pre+nums[i],nums[i]);
            //dp[i]=max(dp[i-1]+num[i],num[i])
            // dp[i]要么自成一派，要么跟之前的数组和连接

            dp_pre=dp_i;
            //将dp[i]的值赋给dp[i-1] 实现状态转移

            res = Math.max(res, dp_i);
        }
        return res;

    }
}
// @lc code=end

