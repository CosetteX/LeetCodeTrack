/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int n=right+1;
        int[] dp=new int[n];
        int mx=0;
        int res=0;

        for (int i=0;i<n;i++){
            dp[i]=mx;
            mx=Math.max(mx, height[i]);
        }
        // 先存入左边的最大值


        mx = 0;
        for (int i = n - 1; i >= 0; --i) {
            dp[i] = Math.min(dp[i], mx);
            // 再存入右边的最大值
            // 在左右的最大值中取最小值
            mx = Math.max(mx, height[i]);
            if (dp[i] - height[i] > 0) {
                res += dp[i] - height[i];
            }
        }
        return res;

        // dynamic programming

    }
}
// @lc code=end

