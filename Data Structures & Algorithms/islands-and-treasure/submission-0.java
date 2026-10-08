class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 0)
                    queue.offer(new int[] {i, j, 0});
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; ++i) {
                int[] curr = queue.poll();
                visited.add(String.valueOf(curr[0]) + "-" + curr[1]);

                for (int d = 0; d < dir.length; ++d) {
                    int x = curr[0] + dir[d][0];
                    int y = curr[1] + dir[d][1];

                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length
                        || grid[x][y] != 2147483647 || visited.contains(x + "-" + y))
                        continue;

                    grid[x][y] = curr[2] + 1;

                    queue.offer(new int[] {x, y, curr[2] + 1});
                }
            }
        }
    }
}