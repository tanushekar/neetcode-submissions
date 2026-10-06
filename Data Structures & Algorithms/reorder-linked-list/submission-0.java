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
    public void reorderList(ListNode head) {
        // break list into 2 halves
        // rotate the second part
        // merge with first

        // to find middle--> dummy node+ slow-fast ptrs

        ListNode dummy= new ListNode(0);
        dummy= head;
        ListNode slow= dummy;
        ListNode fast= head.next;

        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }

        //reverse 2nd part
        ListNode second= slow.next;
        slow.next= null;    // end 1st list with null

        ListNode prev= null;

        while(second != null){
            ListNode temp= second.next;
            second.next= prev;
            prev= second;
            second= temp;
        }

        ListNode first= head;
        second= prev;  // prev will point to last node i.e, first in the reversed list
        
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next= second;
            second.next= temp1;
            first= temp1;
            second= temp2;

        }
    }
}
