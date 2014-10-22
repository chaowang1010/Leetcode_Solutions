// A linked list is given such that each node contains an additional random pointer 
// which could point to any node in the list or null.

// Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */


public class Solution {
 	// Hashmap. Two passes. O(n),O(n).
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode curr = head;
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode newPre = newHead;
        
        map.put(curr, newHead);
        // Copy each node to a new. and store the nodes in hash table.
        while(curr.next != null){
        	RandomListNode temp = new RandomListNode(curr.next.label);
        	map.put(curr.next, temp);
        	newPre.next = temp;
        	newPre = newPre.next;
        	curr = curr.next;
        }

        RandomListNode newCurr = newHead;
        curr = head;
        while(curr != null){
        	newCurr.random = map.get(curr.random);
        	curr = curr.next;
        	newCurr = newCurr.next;
        }
        return newHead;
    }
}