class Solution {
    Map<String, Integer> map;

    private int dfs(int[] nums, int t, int index, int sum) {
        
        String key = String.valueOf(index) + "-" + sum;

        if (map.containsKey(key))
            return map.get(key);

        if (index == nums.length) {
            return sum == t ? 1 : 0;
        } 

        int takeSum = dfs(nums, t, index + 1, sum - nums[index]);
        int takeSub = dfs(nums, t, index + 1, sum + nums[index]);

        map.put(key, takeSum + takeSub);
        return takeSum + takeSub;
    }


    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return dfs(nums, target, 0, 0);
    }
}
