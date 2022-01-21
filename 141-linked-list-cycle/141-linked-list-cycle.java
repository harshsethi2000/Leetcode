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
    public boolean hasCycle(ListNode head) {
      // Method 1
      //     using hashMap simply iterate over the linkedList and insert the node in hashMap
      //     if node already exist that means there is a cycle
      //         TIme COmplexity -O(n)
      //         Space Complexity -O(n)//for storing n nodes
//         HashSet<ListNode> hash=new HashSet<>();
//         while(head!=null)
//         {
//             if(hash.contains(head))return true;
//             hash.add(head);
//             head=head.next;
//         }
//         return false;
              
        // Method 2-
        //     Using Cycle Detection Method Tortoise and hare
        //     In this We will take two pointers slow and fast and increase the slow pointer by 1
        //     and fast pointer by 2 if the slow and fast pointer collides at any point that means
        //         there is cycle present
        //         and if fast->next become null anytime that means there is no cycle
        //             Time Complexity - O(n)
        //             Space COmplexity -O(1)
       
        if(head==null)return false;
        ListNode fast=head,slow=head;
                    while(fast.next!=null && fast.next.next!=null)
                    {
                        
                        slow=slow.next;
                        fast=fast.next.next;
                        if(slow==fast)return true;
                    }
        return false;
    }
}