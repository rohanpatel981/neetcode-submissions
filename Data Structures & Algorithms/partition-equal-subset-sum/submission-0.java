class Solution {
    Map<String, Boolean> memo;
    private boolean dfs(int[] nums, int index, int sum1, int sum2) {

        if (index == nums.length) {
            if (sum1 == sum2)
                return true;
            return false;
        }

        String key = String.valueOf(index) + sum1 + sum2;

        if (memo.containsKey(key))
            return memo.get(key);

        boolean res = false;

        res = res || dfs(nums, index + 1, sum1 + nums[index], sum2);
        res = res || dfs(nums, index + 1, sum1, sum2 + nums[index]);

        memo.put(key, res);
        return res;
    }

    public boolean canPartition(int[] nums) {
        memo = new HashMap<>();
        return dfs(nums, 0, 0, 0);
    }
}
