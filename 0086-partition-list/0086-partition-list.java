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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode l1 = dummy1;    //dummy1 and dummy2 must remain unchanged because they store the starting points of the two partitions
        ListNode l2 = dummy2;
        ListNode current  = head;
        while(current != null){
            if(current.val < x){
                l1.next = current;
                l1 = l1.next;    // Move l1, but dummy1 remains at the start
            }else{
                l2.next = current;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        l2.next = null;
        l1.next = dummy2.next;
        return dummy1.next;
    }
}
