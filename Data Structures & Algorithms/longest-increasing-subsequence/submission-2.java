class Solution {
    int[][] memo;

    private int dfs(int[] nums, int index, int prevIndex) {

        if (index == nums.length)
            return 0;

        int take = 0, leave = 0;

        if (memo[index][prevIndex] != -1)
            return memo[index][prevIndex];

        if (prevIndex == nums.length) {
            take = 1 + dfs(nums, index + 1, index);
        } else if (nums[index] > nums[prevIndex]) {
            take = 1 + dfs(nums, index + 1, index);
        }

        leave = dfs(nums, index + 1, prevIndex);

        memo[index][prevIndex] = Math.max(take, leave);

        return memo[index][prevIndex];
    }

    public int lengthOfLIS(int[] nums) {
        memo = new int[nums.length + 1][nums.length + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dfs(nums, 0, nums.length);
    }
}
