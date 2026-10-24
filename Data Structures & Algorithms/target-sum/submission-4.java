class Solution {
    Map<String, Integer> map;

    private int dfs(int[] nums, int t, int index, int sum) {

        // All numbers have been processed.
        // Count this path if its sum matches the target.
        if (index == nums.length) {
            return sum == t ? 1 : 0;
        }

        // State is defined by the current index and running sum.
        String key = index + "-" + sum;

        // Return the cached answer if this state was solved before.
        if (map.containsKey(key)) {
            return map.get(key);
        }

        // Assign a minus sign to the current number.
        int takeSum = dfs(nums, t, index + 1, sum - nums[index]);

        // Assign a plus sign to the current number.
        int takeSub = dfs(nums, t, index + 1, sum + nums[index]);

        // Count all valid ways from both choices.
        int res = takeSum + takeSub;

        // Cache and return the result.
        map.put(key, res);
        return res;
    }

    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return dfs(nums, target, 0, 0);
    }
}
