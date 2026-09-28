class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        int res = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] x : intervals) {
            if (merged.isEmpty()) {
                merged.add(x);
            } else {
                if (merged.get(merged.size() - 1)[1] > x[0]) {
                    merged.get(merged.size() - 1)[1] = Math.min(merged.get(merged.size() - 1)[1], x[1]);
                    merged.get(merged.size() - 1)[0] = Math.min(merged.get(merged.size() - 1)[0], x[0]);
                } else {
                    merged.add(x);
                }
            }
        }
        return intervals.length - merged.size();
    }
}
