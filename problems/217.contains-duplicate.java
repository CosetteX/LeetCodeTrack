/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */
import java.util.*;
// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length<=1){
            return false;
        }
        
        Map<Integer,Boolean> hashtable=new HashMap<Integer,Boolean>();
        for (int i=0;i<nums.length;i++){
            int temp=nums[i];
            if (hashtable.containsKey(temp)){
                return  true;
                // hashtable.replace(temp, false, true);
            }
            else{
                hashtable.put(temp,false);
            }
        }

        return false;


    }
}
// @lc code=end

