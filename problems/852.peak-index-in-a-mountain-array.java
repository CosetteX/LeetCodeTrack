/*
 * @lc app=leetcode id=852 lang=java
 *
 * [852] Peak Index in a Mountain Array
 */

// @lc code=start
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l=0;
        int r=arr.length-1;
        int mid=l+(r-l)/2;

        while(l<r){
            if(arr[mid]>arr[mid-1]&&arr[mid]<arr[mid+1]){
                l=mid;
                mid=l+(r-l)/2;
            }
            else if (arr[mid]<arr[mid-1]&&arr[mid]>arr[mid+1]){
                r=mid;
                mid=l+(r-l)/2;
            }
            else{
                break;
            }
        }
        return mid;
    }
}
// @lc code=end

