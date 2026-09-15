class Solution {
    public int maxArea(int[] nums) {
        int N = nums.length, res = 0;

        for (int i = 0, j = N - 1; i < j; ) {
            res = Math.max(res, (j - i) * Math.min(nums[i], nums[j]));

            if (nums[i] > nums[j])
                j--;
            else
                i++;
        }

        return res;
    }
}
