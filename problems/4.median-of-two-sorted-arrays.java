/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int left=(m+n+1)/2;
        int right=(m+n+2)/2;

        int median1=getKthElement(left, nums1,0, nums2,0);
        int median2=getKthElement(right, nums1,0, nums2,0);
        return (median1+median2)*0.5;

    }

    public int getKthElement(int k, int[] nums1, int start1, int[] nums2, int start2){
        int length1=nums1.length-start1;
        int length2=nums2.length-start2;

        if (length1>length2)
            return getKthElement(k, nums2, start2, nums1, start1);
        
        if (length1==0){
            return nums2[start2+k-1];
        }
    
        if (k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }

        int i=start1+Math.min(length1, k/2)-1;
        int j = start2+Math.min(length2,k/2)-1;

        if (nums1[i]>nums2[j]){
            return getKthElement(k-(j-start2+1), nums1, start1, nums2, j+1);
        }
        else{
            return getKthElement(k-(i-start1+1), nums1, i+1, nums2, start2);
        }
    }
}


// @lc code=end

