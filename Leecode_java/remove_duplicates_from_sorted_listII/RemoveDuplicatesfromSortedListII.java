public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy, curr = head;
        
        while(curr != null && curr.next != null){
            if(pre.next.val == curr.next.val){
                while(curr.next != null && curr.next.val == pre.next.val)
                {
                    curr = curr.next;
                }
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}