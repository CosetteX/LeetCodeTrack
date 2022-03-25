/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int min=prices[0];
        int len=prices.length;


        for (int i=0;i<len;i++){
            if(prices[i]<min){
                min=prices[i];
            }
            max=Math.max(max,prices[i]-min);

        }
        
        return max;
    }
}
// @lc code=end

