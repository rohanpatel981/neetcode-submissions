/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(0);
        Node h = head;
        Map<Node, Node> hmap = new HashMap<>();
        Node prev = newHead;

        while (h != null) {
            Node node = new Node(h.val);
            prev.next = node;
            prev = node;
            hmap.put(h, node);
            h = h.next;
        }

        h = newHead.next;

        while (h != null && head != null) {
            Node r = head.random;

            if (r == null)
                h.random = r;
            else {
                h.random = hmap.get(r);
            }
            head = head.next;
            h = h.next;
        }

        return newHead.next;        
    }
}
