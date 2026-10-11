class WordDictionary {
    class Node {
        Node[] child = new Node[26];
        boolean isWord;
    }

    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int x = c - 'a';

            if (curr.child[x] == null)
                curr.child[x] = new Node();
            
            curr = curr.child[x];
        }

        curr.isWord = true;
    }

    public boolean dfs(String word, int index, Node curr) {
        if (index >= word.length())
            return curr.isWord;
        
        char c = word.charAt(index);

        if (c == '.') {
            for (Node n : curr.child) {
                if (n != null) {
                    if (dfs(word, index + 1, n))
                        return true;
                }
            }

            return false;
        }

        int x = c - 'a';

        if (curr.child[x] == null)
            return false;
        
        return dfs(word, index + 1, curr.child[x]);
        
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
}
