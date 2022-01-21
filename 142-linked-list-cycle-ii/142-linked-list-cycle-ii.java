/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
//         Method 1
// //             Simply use hashMap
//         HashSet<ListNode> hash=new HashSet<>();
//         while(head!=null)
//         {
//             if(hash.contains(head))return head;
//             hash.add(head);
//             head=head.next;
//         }
//         return null;
//         Method 2 -
//             Using Fast and slow pointer with little changes
//             We know that if there is a cycle then slow and fast pointer will collide at some                  point
//             so if collision happen we will take another pointer tmp and move tmp and slow       //             by 1. and see where they collide.
        if(head==null || head.next==null)return null;
              ListNode slow=head,fast=head,tmp=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        
            if(slow==fast)
            {
                while(tmp!=slow)
                {
                    slow=slow.next;
                    tmp=tmp.next;
                }
                return slow;
            }
        }
        return null;
                    
    }
}