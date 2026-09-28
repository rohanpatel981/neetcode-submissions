class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();

        for (int[] x : intervals) {
            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                if (stack.peek()[1] >= x[0]) {
                    int[] t = stack.pop();
                    stack.push(new int[]{t[0], Math.max(t[1], x[1])});
                } else {
                    stack.push(x);
                }
            }
        }

        int[][] res = new int[stack.size()][2];

        for (int i = stack.size() - 1; i >= 0; --i) {
            res[i][0] = stack.peek()[0];
            res[i][1] = stack.pop()[1];
        }

        return res;
    }
}
