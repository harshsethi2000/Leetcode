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
    public ListNode rotateRight(ListNode head, int k) {
//         Method 1
//             Simply iterate over k times and rotate to the right by 1
//             Time Complexity -o(n*k)
//             Method 2-
//                 1. find Size of the linkedList.
//                 2. point the last node->next to the first node.
//                 3. Since K can be greater than length soo we can break k by
//                    k=k%length
//                 4. Go to the n-k th node and change head value to last node(now first node) and k-n th node next value to null
//                 Time Complexity -O(n)+O(n-k)
//                 Space Complexity -O(1)
        if(head==null)return null;
        if(k==0)return head;
        //calculate size of ll
        ListNode t=head;
        int size=1;
        while(t.next!=null)
        {
            size++;
            t=t.next;
        }
        t.next=head;
        int end=size-k%size;
        
        while(--end>=0)t=t.next;
        head=t.next;
        t.next=null;
        return head;
        
    }
}