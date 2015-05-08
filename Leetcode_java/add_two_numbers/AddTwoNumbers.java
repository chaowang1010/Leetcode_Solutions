public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int carry = 0; 
        int sum = 0;
        ListNode result = null;
        ListNode curr = null;
        
        while(l1 != null || l2 != null){
            sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            // if(sum > 9){
            //     carry = 1;
            // }else{
            //     carry = 0;
            // }
            carry = sum / 10;
            
            if(curr == null){
                curr = new ListNode(sum % 10);
                result = curr;
            }else{
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
            }
            
        }
        if (carry>0) curr.next = new ListNode(carry);  
        return result;
    }
}