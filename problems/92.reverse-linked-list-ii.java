import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead=new ListNode();
        ListNode p=newHead;
        ListNode q=head;
        int index=1;

        // 首先找到[1,left)
        while(index<left){
            p.next=q;
            p=q;
            q=q.next;
            index++;
        }
       
        ListNode flag = q;
        // flag记录了[1,left)的终点位置/[left,right]的起点位置

        //[left,right] 头插法反转链表
        //需要记录第一个头插法的元素 因为翻转后变成表尾
        
        ListNode temp;
        while (index <= right){
            //头插法
            temp = q.next;
            q.next = p.next;
            p.next = q;
            q = temp;
            index++;
        }
        //(right,n]
        flag.next = q;
        return newHead.next;

    }
}
// @lc code=end

