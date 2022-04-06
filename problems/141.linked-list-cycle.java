/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
    public boolean hasCycle(ListNode head) {
        //快慢指针
        if (head==null|| head.next==null){
            return false;
        }
        
        ListNode slow=head;
        ListNode fast=head.next;

        // 龟兔赛跑的追及问题，一圈圈地追一定能追上

        while(slow!=fast){
            if (fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }

        return true;

        
    }
}
// @lc code=end

