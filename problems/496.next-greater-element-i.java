/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start

import java.util.*;
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
       Map<Integer, Integer> map=new HashMap<Integer, Integer>();
       int m=nums2.length;
       Stack<Integer> stack=new Stack<>();

       for(int i=m-1; i>=0;i--){
        //    栈底到栈顶单调递减
        // 保证大元素会被放进栈中

            while(!stack.isEmpty()&& nums2[i]>stack.peek()){
                // 不断弹出栈顶的小元素，直到栈顶元素>nums2[i]
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);


       }
       int[] arr=new int[nums1.length];
       for (int i=0;i<nums1.length;i++){
           arr[i]=map.get(nums1[i]);
       }
       return arr;
    }
}
// @lc code=end

