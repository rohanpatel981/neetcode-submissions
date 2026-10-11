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
        int size = 0;

        ListNode tempHead = head;

        while (tempHead != null) {
            size++;
            tempHead = tempHead.next;
        }

        n = size - n; // 4 - 2 = 3

        tempHead = head;
        ListNode prev = null;
        while (tempHead != null && n > 0) {
            n--;
            prev = tempHead;
            tempHead = tempHead.next;
        }

        if (prev == null)
            return head.next;

        prev.next = tempHead.next;
        return head;
    }
}
