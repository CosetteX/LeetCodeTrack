/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start

import java.util.*;
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer,Integer> hashtable=new HashMap<Integer,Integer>();

        for (int i : nums1){
            int count=hashtable.getOrDefault(i,0)+1;
            hashtable.put(i,count);
        }

        int[] result=new int[nums1.length];
        int retIndex=0;

        for(int i:nums2){
            int count=hashtable.getOrDefault(i, 0);
            if (count > 0) {
                // 如果这个数在nums1中出现过
                result[retIndex++]=i;
                count--;
                if (count>0){
                    hashtable.put(i,count);
                    //更新hashmap的值
                }else{
                    hashtable.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, retIndex);
    }
}
// @lc code=end

