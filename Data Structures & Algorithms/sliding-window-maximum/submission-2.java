class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] left = new int[N];
        int[] right = new int[N];
        int[] res = new int[N - k + 1];

        right[N - 1] = nums[N - 1];
        left[0] = nums[0];

        for (int i = 1; i < N; ++i) {
            if (i % k == 0)
                left[i] = nums[i];
            else
                left[i] = Math.max(nums[i], left[i - 1]);
        }

        for (int i = N - 2; i >= 0; --i) {
            if (i % k == 0)
                right[i] = nums[i];
            else
                right[i] = Math.max(nums[i], right[i + 1]);
        }

        for (int i = 0; i < N - k + 1; ++i) 
            res[i] = Math.max(left[i + k - 1], right[i]);

        return res;
    }
}
