/*
 * @lc app=leetcode id=410 lang=java
 *
 * [410] Split Array Largest Sum
 */

// @lc code=start
class Solution {
    public int splitArray(int[] nums, int m) {
        // 第一感觉有点像capacity to ship packages within D days那道题
        // capacity：求一个最小的容量 保证在这个容量下 d天可以运完货物
        // 这道题求的minimum largest sum 就是这个最小容量，d天对应m个subarray
        

        // largest sum的上界r：sum(nums)
        // 下界l：max(nums中的最大值，nums/m)
        // mid=(l+r)/2

        int l=0;
        int r=0;
        for (int num:nums){
            if (num>l){
                l=num;
            }
            r+=num;
        }
        l=Math.max(l, r/m);
        int mid=(l+r)/2;

        while(l<=r){
            mid=(l+r)/2;
            if (canFinish(nums, m,mid)){
                r=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return l;
    }

    public boolean canFinish(int[] nums,int m,int bound){
        

        int cnt=1;
        // 注意这里的边界判断
        int remain_sum=bound;
        for (int num: nums){
            if (remain_sum<num){
                remain_sum=bound;
                cnt++;
            }
            remain_sum-=num;

        }
        return cnt<=m;
    }
}
// @lc code=end

