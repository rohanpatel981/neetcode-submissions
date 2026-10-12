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
        ListNode prev = null;
        ListNode p = head;
        int size = 0;
        Map<ListNode, ListNode> prevMap = new HashMap<>();

        while (p != null) {
            prevMap.put(p, prev);
            prev = p;
            p = p.next;
            size++;
        }

        p = head;

        int times = size % 2 != 0 ? size/2 : (size/2) - 1;

        for (int i = 0; i < times; ++i) {
            ListNode temp = p.next;
            prev.next = null;
            p.next = prev;

            p.next.next = temp;
            p = p.next.next;
            prev = prevMap.get(prev);
            prev.next = null;
        }
    }
}
