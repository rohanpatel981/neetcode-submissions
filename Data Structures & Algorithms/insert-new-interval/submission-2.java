class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][]{newInterval};

        int[][] res = new int[intervals.length + 1][intervals[0].length];

        for (int i = 0; i < intervals.length; ++i) {
            for (int j = 0; j < intervals[0].length; ++j) {
                res[i][j] = intervals[i][j];
            }
        }

        res[res.length - 1] = newInterval;

        Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<int[]> stack = new Stack<>();

        for (int[] interval : res) { // [1 2] [3 8] 
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                if (stack.peek()[1] >= interval[0]) {
                    int[] temp = stack.pop();
                    stack.push(new int[]{temp[0], Math.max(interval[1], temp[1])});
                } else {
                    stack.push(interval);
                }
            }
        }

        int[][] ans = new int[stack.size()][2];

        for (int i = stack.size() - 1; i >= 0; --i) {
            ans[i][0] = stack.peek()[0];
            ans[i][1] = stack.pop()[1];
        }

        return ans;
    }
}
