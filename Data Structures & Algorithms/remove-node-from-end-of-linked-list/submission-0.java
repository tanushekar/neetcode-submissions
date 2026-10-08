//LC-19
// MOVE FAST PTR N STEPS AHEAD
// WHEN FAST IS AT LAST NODE--> SLOW WILL BE AT THE POS BEFORE DELETION

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

        //dummy to handle 1 node
        ListNode dummy= new ListNode(0);
        dummy.next= head;
        ListNode slow= dummy;
        ListNode fast= dummy;

        //move fast n times
        for(int i=0; i<n; i++){
            fast= fast.next;
        }

        while(fast.next!= null){
            fast= fast.next;
            slow= slow.next;
        }

        slow.next= slow.next.next;

        return dummy.next;
    }
}