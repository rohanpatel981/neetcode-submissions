class Solution {
    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] left = new int[N];
        int[] right = new int[N];
        int[] res = new int[N];

        for (int i = 0; i < N; ++i) {
            if (i == 0)
                left[i] = nums[i];
            else
                left[i] = nums[i] * left[i - 1];
        }

        for (int i = N - 1; i > 0; i--) {
            if (i == N - 1)
                right[i] = nums[i];
            else
                right[i] = right[i + 1] * nums[i];
        }

        for (int i = 0; i < N; ++i) {
            int l = i == 0 ? 1 : left[i - 1];
            int r = i == N - 1 ? 1 : right[i + 1];
            res[i] = l * r;
        }

        return res;
    }
}  

