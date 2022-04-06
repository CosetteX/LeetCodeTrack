/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode result=new ListNode(-1);
        result.next=head;
        // 先用fast探路
        // result有一个空头，方便操作

        ListNode fast=head,slow=result;
        while(fast!=null){
            if (fast.val==val){
                slow.next=fast.next;
            }
            else{
                slow=slow.next;
            }
            fast=fast.next;
        }
        return result.next;
    }
}
// @lc code=end

