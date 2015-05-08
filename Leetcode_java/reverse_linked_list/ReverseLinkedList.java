/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // iterative
    // public ListNode reverseList(ListNode head) {
    //     ListNode l = null;
    //     while(head != null){
    //         ListNode tmp = head.next;
    //         head.next = l;
    //         l = head;
    //         head = tmp;
    //     }
    //     return l;
    // }
    // recursive
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}