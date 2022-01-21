/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
//        Note- we have to find intersection based on reference of the node not the values.
//         Method 1-
//            We will iterate over first linkedList and simply find that node in 
//            second linked 
//         ListNode i=headA; 
//       while(i!=null)
//        {
//            ListNode j=headB;
//            while(j!=null)
//            {
//                if(i==j)return i;
//                j=j.next;
//            }
//           i=i.next;
           
//        }
//         return null;
        
        // Method 2-
        //     Using HashMap considering the searching operation in HashMap takes O(1)
        //     we can simply insert nodes of first ll in HashMap and then iterate over the second
        //     linkedList and check if that node exists in HashMap or not if yes then return that                 node else return null.
        //     Time Complexity - O(n+m) Iterating through list 1 first takes O(n), then iterating through list 2 takes O(m). 
        //     space Complexity -O(n)  Storing list 1 node addresses in HashSet.
        
//                 HashSet<ListNode> hash=new HashSet<>();
//         //add in hashSet
//         while(headA!=null)
//         {
//             hash.add(headA);
//             headA=headA.next;
//         }
//         //search in hashSet
//         while(headB!=null)
//         {
//             if(hash.contains(headB))return headB;
//             headB=headB.next;
//         }
//         return null;
        
//         Method 3-
//             We will find the difference in the length of both the linkedList
//             and to the smallest length linkedList move our pointer by 1 to the next node
//             and then simply iterate over firstlinked list and increase the both pointer by 1
            
            int diff=getDiff(head1,head2);
            if(diff<0)
            {
                //ll two is greater in size
                while(diff++ !=0)head2=head2.next;
            }else
            {
                //ll one is greater in size
                while(diff--!=0)head1=head1.next;
            }
        while(head1!=null)
        {
            if(head1==head2)return head1;
            head1=head1.next;
            head2=head2.next;
        }
        return null;
    }
    public int getDiff(ListNode head1,ListNode head2)
    {
        int i=0,j=0;
        while(head1!=null)
        {
            i++;
            head1=head1.next;
        }
        while(head2!=null)
        {
            j++;
            head2=head2.next;
        }
        return i-j; //if negative that means length of second ll is greater
    }
}