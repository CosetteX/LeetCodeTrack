import java.util.HashMap;
import java.util.*;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start

// a basic idea of traversing all the elements
// O(n^2)
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         int n=nums.length;
//         for (int i=0; i<n; i++){
//             for (int j = i+1; j<n; j++){
//                 if(nums[i]+nums[j]==target){
//                     return new int[]{i,j};
//                 }
//             }
//         }
//         return new int[0];
//     }
// }


// use hashmap

class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hashtable=new HashMap<Integer,Integer>();

            int n=nums.length;

            for (int i=0;i<n;i++){
                if (hashtable.containsKey(target-nums[i])){
                    return new int[] {hashtable.get(target-nums[i]),i};
                }
                hashtable.put(nums[i],i);

            }

            return new int[0];
        }
        
    }

// @lc code=end

