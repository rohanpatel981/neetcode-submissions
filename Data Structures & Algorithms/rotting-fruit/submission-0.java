class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, row = grid.length, col = grid[0].length, res = 0;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                
                if (grid[i][j] == 1)
                    fresh++;
            }
        
        int[][] dir = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        
        while (!queue.isEmpty()) {
            int sz = queue.size();

            if (fresh == 0)
                break;

            for (int i = 0; i < sz; ++i) {
                int[] curr = queue.poll();

                for (int d = 0; d < 4; ++d) {
                    int xx = curr[0] + dir[d][0];
                    int yy = curr[1] + dir[d][1];

                    if (xx < 0 || xx >= row || yy < 0 || yy >= col || grid[xx][yy] != 1)
                        continue;
                    
                    grid[xx][yy] = 2;
                    queue.offer(new int[]{xx, yy});
                    fresh--;
                }
            }
            res++;
        }

        return fresh == 0 ? res : -1;
    }
}
