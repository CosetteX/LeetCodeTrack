/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 因为empty的空间在数组后部，所以我们从大的数字开始比较 就可以避免经常挪动数字！

        int idx_1=m-1;
        int idx_2=n-1;
        int idx=m+n-1;

        while(idx_1>=0&&idx_2>=0){
            if (nums1[idx_1]>=nums2[idx_2]){
                nums1[idx]=nums1[idx_1];
                idx_1--;
                idx--;
            }
            else{
                nums1[idx]=nums2[idx_2];
                idx_2--;
                idx--;
            }
        }
        
        while(idx_2>=0){
            nums1[idx--]=nums2[idx_2--];
        }
    }
}
// @lc code=end

