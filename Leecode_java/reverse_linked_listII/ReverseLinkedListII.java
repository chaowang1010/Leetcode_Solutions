// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.



public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy, l2 = head;
        //locate the nodes
        while(n > 0){
            l2 = l2.next;
            n --;
        }
        
        while(--m > 0){
            l1 = l1.next;
        }
        ListNode curr = l1.next;
        while(curr.next != l2){
            // change position between curr.next and curr
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = l1.next;
            l1.next = temp;
        }
        return dummy.next;
    }
}