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
    public ListNode middleNode(ListNode head) {
        //using tortoise-Hare method
        //The intitution here is that fast will move 2 times faster than slow
        //so if fast becomes null that means our slow pointer is at n/2 distance from start
        ListNode slow,fast;
        //initilize two pointer fast and slow
        slow=head;
        fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
}