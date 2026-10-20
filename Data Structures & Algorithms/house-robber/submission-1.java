class Solution {
    Map<Integer, Integer> memoMap;

    private int dfs(int[] nums, int index) {
        if (index >= nums.length)
            return 0;
        
        if (memoMap.containsKey(index))
            return memoMap.get(index);
        
        int take = nums[index] + dfs(nums, index + 2);
        int leave = dfs(nums, index + 1);

        memoMap.put(index, Math.max(take, leave));

        return memoMap.get(index);
    }

    public int rob(int[] nums) {
        memoMap = new HashMap<>();
        return dfs(nums, 0);
    }
}
