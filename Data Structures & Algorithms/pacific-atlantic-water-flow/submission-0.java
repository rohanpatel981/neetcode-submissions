class Solution {
    private void dfs(int[][] h, int i, int j, boolean[][] visited, int prev) {
        if (i < 0 || j < 0 || i >= h.length || j >= h[0].length || visited[i][j] || prev > h[i][j])
            return;

        visited[i][j] = true; 

        dfs(h, i + 1, j, visited, h[i][j]);
        dfs(h, i - 1, j, visited, h[i][j]);
        dfs(h, i, j - 1, visited, h[i][j]);
        dfs(h, i, j + 1, visited, h[i][j]);
    } 

    public List<List<Integer>> pacificAtlantic(int[][] h) {
        int M = h.length, N = h[0].length;
        boolean[][] a = new boolean[M][N];
        boolean[][] p = new boolean[M][N];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            dfs(h, 0, i, p, h[0][i]);
            dfs(h, M - 1, i, a, h[M - 1][i]);
        }

        for (int i = 0; i < M; ++i) {
            dfs(h, i, 0, p, h[i][0]);
            dfs(h, i, N - 1, a, h[i][N - 1]);
        }

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (a[i][j] && p[i][j])
                    res.add(List.of(i, j));
            }
        }

        return res;
    }
}
