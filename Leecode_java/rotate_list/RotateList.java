public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(n < 1 || head == null) return head;
        int length = 0;
        ListNode curr = head;
        while(curr.next != null) {
            curr = curr.next;
            length++;
        }
        length ++;
        n = n % length;
        curr.next = head;
        while(length > n + 1){
            --length;
            head = head.next;
        }
        curr = head.next;
        head.next = null;
        return curr;
    }
}