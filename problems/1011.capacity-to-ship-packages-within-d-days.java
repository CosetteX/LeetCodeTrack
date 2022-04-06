/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0;
        int sum=0;
        for(int weight: weights){
            sum+=weight;
            if(weight>l){
                l=weight;
            }
        }

        l=Math.max(l, sum/days);

        int r=sum;
        while(l<=r){
            int mid = (l + r)/2;
            if (canFinish(weights, days, mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return l;

    }
    private boolean canFinish(int[] weights, int days, int cap) {
        int day = 1, cur = cap;
        // cur 当天可以增加的weight重量

        
        for (int weight : weights) {
            if (weight > cur) {
                // weight>cur, 需要额外增加一天
                day++;
                // 清空我们的小船 可重新装cap重量啦！
                cur = cap;
            }
            // weigh<cur
            // 继续往上放
            cur -= weight;
        }
        return day <= days;
    }

}
// @lc code=end

