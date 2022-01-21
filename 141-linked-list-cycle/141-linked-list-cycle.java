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
        HashSet<ListNode> hash=new HashSet<>();
        while(head!=null)
        {
            if(hash.contains(head))return true;
            hash.add(head);
            head=head.next;
        }
        return false;
              
    }
}