class Solution {
    private int traverse(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return 0;

        grid[i][j] = 2;
        return traverse(grid, i + 1, j) + traverse(grid, i - 1, j) + traverse(grid, i, j + 1)
            + traverse(grid, i, j - 1) + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, traverse(grid, i, j));
                }
            }
        }

        return res;
    }
}
