class Solution {
    int[] state;
    private boolean isCycle(List<List<Integer>> edges, int node) {

        if (state[node] == 1)
            return false;
        
        if (state[node] == 2)
            return true;
        
        state[node] = 1;

        boolean res = true;

        for (Integer next : edges.get(node)) {
            if (state[next] == 1)
                return false;
            else
                res = res && isCycle(edges, next);
            
            if (!res)
                break;
        }

        state[node] = 2;
        return res;
    }

    public boolean canFinish(int num, int[][] p) {
        List<List<Integer>> edges = new ArrayList<>();
        state = new int[num];

        for (int i = 0; i < num; ++i)
            edges.add(new ArrayList<>());

        for (int[] e : p) {
            edges.get(e[0]).add(e[1]);
        }

        for (int i = 0; i < num; ++i) {
            if (!isCycle(edges, i))
                return false;
        }

        return true;
    }
}
