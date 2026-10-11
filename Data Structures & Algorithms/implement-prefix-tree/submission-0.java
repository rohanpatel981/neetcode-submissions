class PrefixTree {

    private final Node root;

    class Node {
        Node[] children = new Node[26];
        boolean isLeaf;
    }

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int x = c - 'a';

            if (curr.children[x] == null)
                curr.children[x] = new Node();
            
            curr = curr.children[x];
        }

        curr.isLeaf = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int x = c - 'a';

            if (curr.children[x] == null)
                return false;
            
            curr = curr.children[x];
        }

        return curr.isLeaf;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (char c : prefix.toCharArray()) {
            int x = c - 'a';

            if (curr.children[x] == null)
                return false;
            curr = curr.children[x];
        }

        return true;
    }
}
