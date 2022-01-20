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
    public ListNode removeNthFromEnd(ListNode head, int n) {
      //simply calculate size and then delete size-n th node
        if(head==null)return null;
        int size=0;ListNode l;
        for(l=head;l!=null;l=l.next)
        {
            size++;
        }
        l=head;
        if(size==n)
        {
            
            head=head.next;
            return head;
        }
        for(int i=1;i<size-n;i++)
        {
            l=l.next;
        }
        l.next=l.next.next;
        if(size-n-1==0)head=l;
        return head;
    }
}