import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ret=new int [n];
        Arrays.fill(ret,-1);
        Deque<Integer> stack=new LinkedList<Integer>();
        // 在单调栈中存放数组下标
        for(int i=0;i<n*2-1;i++){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i%n]){
                 ret[stack.pop()]=nums[i%n];
            }
           stack.push(i%n);
        }
        return ret;
    }
}
// @lc code=end

