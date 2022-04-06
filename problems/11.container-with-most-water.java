/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j=height.length-1;
        int res=0;

        while(j>i){
            int left=height[i];
            int right=height[j];
            int area=Math.min(left, right)*(j-i);

            res=Math.max(res,area);

            if(left>right){
                j--;
            }
            else{
                i++;
            }
        }
        return res;
    }
}
// @lc code=end

