class Solution {
    Map<Integer, Integer> memoMap;

    private int dfs(int[] nums, int index, int end) {
        if (index >= end)
            return 0;
        
        if (memoMap.containsKey(index))
            return memoMap.get(index);
        
        int take = nums[index] + dfs(nums, index + 2, end);
        int leave = dfs(nums, index + 1, end);

        memoMap.put(index, Math.max(take, leave));

        return memoMap.get(index);
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        memoMap = new HashMap<>();
        int a = dfs(nums, 0, nums.length - 1);
        memoMap = new HashMap<>();
        int b = dfs(nums, 1, nums.length);
        return Math.max(a, b);
    }
}
