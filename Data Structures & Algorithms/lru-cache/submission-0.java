class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> hmap;
    private Integer cap;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.hmap = new HashMap<>();
        this.cap = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        this.head.next = tail;
        this.tail.prev = head;
    }

    private void insertNodeAtTheEnd(Node node) {
        Node prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if (!hmap.containsKey(key)) {
            return -1;
        }

        Node node = new Node(key, hmap.get(key).value);
        removeNode(hmap.get(key));
        insertNodeAtTheEnd(node);
        hmap.put(key, node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (hmap.containsKey(key)) {
            Node node = new Node(key, value);
            removeNode(hmap.get(key));
            insertNodeAtTheEnd(node);
            hmap.put(key, node);
        } else {
            Node node = new Node(key, value);
            insertNodeAtTheEnd(node);
            hmap.put(key, node);

            if (hmap.size() > cap) {
                hmap.remove(this.head.next.key);
                removeNode(this.head.next);
            }
        }
    }
}
