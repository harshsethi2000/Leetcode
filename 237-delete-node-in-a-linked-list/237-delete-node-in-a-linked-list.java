/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode t) {
        //we are given with node reference that we have to delete
        // so instead of deleting that node we could change it's value 
        //with next nod and cchange the next of given node to t.next=t.next.next
        //Time Complexity - O(1)
        t.val=t.next.val;
        t.next=t.next.next;
        
    }
}