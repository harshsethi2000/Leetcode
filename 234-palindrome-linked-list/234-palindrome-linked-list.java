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
    public boolean isPalindrome(ListNode head) {
      
//         Method 1-
//             1. First find the first middle element, remeber first middle element.
//             2. Reverse the LinkedList from middleNode->next to end
//             3. Move our slow->next=NodeAfterReversing
//             4. Move slow pointer to reversed node
//             5. Initialize tmp=head
//             6. compare tmp.val with slow.val if not same return false.
//             7. after iterating return true
//                 Time Complexity -O(n/2)+O(n/2)+O(n/2)
        //         Space Complexity -O(1)
        
         if(head==null||head.next==null) return true;
        //find middle node
        ListNode slow=head,fast=head;
        while(fast.next!=null &&fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        //slow is pointing towards first middle element
        slow.next=reverse(slow.next);
        slow=slow.next;
        ListNode tmp=head;
        while(slow!=null)
        {
            if(slow.val!=tmp.val)return false;
            tmp=tmp.next;
            slow=slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode node)
    {
        ListNode prev=null;
        ListNode curr=node;
        ListNode next;
        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            
            prev=curr;
            curr=next;
        }
        return prev;
    }
}