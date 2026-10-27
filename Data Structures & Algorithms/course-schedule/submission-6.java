class Solution {
    Map<Integer, Boolean> marked;
    private boolean isCycle(List<List<Integer>> edges, int node, Set<Integer> visited) {

        if (visited.contains(node))
            return false;
        
        if (marked.containsKey(node))
            return marked.get(node);

        visited.add(node);

        boolean res = true;

        for (Integer next : edges.get(node)) {
            if (visited.contains(next))
                return false;
            else
                res = res && isCycle(edges, next, visited);
            
            if (!res)
                break;
        }

        visited.remove(node);
        marked.put(node, res);
        return res;
    }

    public boolean canFinish(int num, int[][] p) {
        List<List<Integer>> edges = new ArrayList<>();
        marked = new HashMap<>();

        for (int i = 0; i < num; ++i)
            edges.add(new ArrayList<>());

        for (int[] e : p) {
            edges.get(e[0]).add(e[1]);
        }

        for (int i = 0; i < num; ++i) {
            if (!isCycle(edges, i, new HashSet<>()))
                return false;
        }

        return true;
    }
}
