
class Solution {
    int[] state;

    private boolean isAcyclic(List<List<Integer>> edges, int node,
                              List<Integer> res) {
        if (state[node] == 1)
            return false;

        if (state[node] == 2)
            return true;

        state[node] = 1;

        for (int next : edges.get(node)) {
            if (!isAcyclic(edges, next, res))
                return false;
        }

        state[node] = 2;
        res.add(node);
        return true;
    }

    public int[] findOrder(int num, int[][] p) {
        state = new int[num];
        List<List<Integer>> edges = new ArrayList<>();

        for (int i = 0; i < num; i++)
            edges.add(new ArrayList<>());

        for (int[] e : p)
            edges.get(e[0]).add(e[1]);

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            if (!isAcyclic(edges, i, res))
                return new int[0];
        }

        int[] ans = new int[num];
        for (int i = 0; i < num; i++)
            ans[i] = res.get(i);

        return ans;
    }
}
