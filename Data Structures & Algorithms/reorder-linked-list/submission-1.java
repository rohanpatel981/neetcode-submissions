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
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        ListNode curr = second;
        ListNode prev = null;

        while (curr != null) { // 5 -> null 6 -> 5 10
            ListNode next = curr.next; // 10
            curr.next = prev;
            prev = curr; // 5
            curr = next; // 6
        }

        second = prev;
        ListNode first = head;

        while (second != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            second.next = first.next;
            first.next = second;

            second = secondNext;
            first = firstNext;
        }
    }
}
