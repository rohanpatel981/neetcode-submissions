class Solution {

    int[][] memo;

    private int dfs(List<List<int[]>> adj, int s, int d, int k) {
        if (k < 0)
            return Integer.MAX_VALUE;

        if (s == d)
            return 0;

        if (memo[s][k] != -1)
            return memo[s][k];

        int curr_price = Integer.MAX_VALUE;

        for (int[] curr : adj.get(s)) {

            int remaining = dfs(adj, curr[0], d, k - 1);

            // Avoid integer overflow
            if (remaining != Integer.MAX_VALUE) {

                int p = curr[1] + remaining;

                curr_price = Math.min(p, curr_price);
            }
        }

        memo[s][k] = curr_price;

        return curr_price;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        memo = new int[n][k + 2];
        
        for (int[] m : memo)
            Arrays.fill(m, -1);

        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());

        for (int[] flight : flights) {
            int source = flight[0];
            int dest = flight[1];
            int price = flight[2];

            adj.get(source).add(new int[]{dest, price});
        }

        int ans = dfs(adj, src, dst, k + 1);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}