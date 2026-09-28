class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0)
            return new int[][] {newInterval};

        boolean added = false;
        int[][] res = new int[intervals.length + 1][intervals[0].length];

        for (int i = 0, k = 0; i < intervals.length; ++i, k++) {
            if (!added && newInterval[0] < intervals[i][0]) {
                res[k][0] = newInterval[0];
                res[k][1] = newInterval[1];
                added = true;
                i--;
            } else {
                for (int j = 0; j < res[0].length; ++j) {
                    res[k][j] = intervals[i][j];
                }
            }
        }

        if (!added) {
            res[intervals.length] = newInterval;
        }

        Stack<int[]> stack = new Stack<>();

        for (int[] interval : res) { // [1 2] [3 8]
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                if (stack.peek()[1] >= interval[0]) {
                    int[] temp = stack.pop();
                    stack.push(new int[] {temp[0], Math.max(interval[1], temp[1])});
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
