class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length, window = k;
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int right = 0; right < N; ++right) {

            while (!pq.isEmpty() && pq.peek()[1] < right - window + 1) {
                pq.poll();
            }
            
            pq.offer(new int[]{nums[right], right});
            k--;

            if (k <= 0) {
                res.add(pq.peek()[0]);
            }

        }

        int[] ans = new int[res.size()];

        for (int i = 0; i < ans.length; ++i)
            ans[i] = res.get(i);

        return ans;
    }
}
