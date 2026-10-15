class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length, n = edges[0].length;

        List<List<Integer>> adj = new ArrayList<>(m + 1);
        for (int i = 0; i <= m; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = m - 1; i >= 0; --i) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v); // Retrieve the list at index u and add v
            adj.get(v).add(u); // Retrieve the list at index v and add u
        }

        for (int i = m - 1; i >= 0; i--) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).remove(Integer.valueOf(v));
            adj.get(v).remove(Integer.valueOf(u));

            if (traverse(adj, u, v, new HashSet<>()))
                return new int[] {u, v};

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return null;
    }

    private boolean traverse(List<List<Integer>> adj, int curr, int target, Set<Integer> visited) {
        if (curr == target)
            return true;
        
        if (visited.contains(curr))
            return false;
        
        visited.add(curr);

        boolean ans = false;

        for (Integer goTo : adj.get(curr)) {
            ans = ans || traverse(adj, goTo, target, visited);
        }

        return ans;
    }
}
