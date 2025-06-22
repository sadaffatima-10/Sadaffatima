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
        ListNode current = head;
        ListNode prev = head;

        if(head == null){
            return head;
        }

        int count = 1;
        while(current.next != null){
            current = current.next;
            count += 1;
        }
        k = k % count;
        int i = 1;
        while(i < count - k){
            prev = prev.next;
            i++;
        }

        current.next = head;
        head = prev.next;
        prev.next = null;

        return head;
    }
}