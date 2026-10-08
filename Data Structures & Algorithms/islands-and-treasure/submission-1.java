class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0)
                    queue.offer(new int[] {i, j});
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; ++i) {
                int[] curr = queue.poll();

                for (int d = 0; d < dir.length; ++d) {
                    int x = curr[0] + dir[d][0];
                    int y = curr[1] + dir[d][1];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                        || grid[x][y] != 2147483647)
                        continue;

                    grid[x][y] = grid[curr[0]][curr[1]] + 1;

                    queue.offer(new int[] {x, y});
                }
            }
        }
    }
}