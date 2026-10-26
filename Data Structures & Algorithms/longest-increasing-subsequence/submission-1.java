class Solution {
    Map<String, Integer> memo;

    private int dfs(int[] nums, int index, int prev) {

        String key = String.valueOf(index) + "-" + prev;

        if (index == nums.length)
            return 0;

        int take = 0, leave = 0;

        if (memo.containsKey(key))
            return memo.get(key);

        if (prev == Integer.MIN_VALUE) {
            take = 1 + dfs(nums, index + 1, nums[index]);
        } else if (nums[index] > prev) {
            take = 1 + dfs(nums, index + 1, nums[index]);
        }

        leave = dfs(nums, index + 1, prev);

        memo.put(key, Math.max(take, leave));

        return memo.get(key);
    }

    public int lengthOfLIS(int[] nums) {
        memo = new HashMap<>();
        return dfs(nums, 0, Integer.MIN_VALUE);
    }
}
