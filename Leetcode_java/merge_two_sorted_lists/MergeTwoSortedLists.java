public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        // root  make sure l1 and l2 point to the next
        ListNode root = null;
        if(l1.val >= l2.val){
            root = l2;
            l2 = l2.next;
        }
        else {
            root = l1;
            l1 = l1.next;
        }
        
        ListNode curr = root;
        while(l1 != null || l2 != null){
            if(l1 == null || (l2 != null && l1.val >= l2.val)){
                curr.next = l2;
                l2 = l2.next;
            }
            else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        return root;
    }
}