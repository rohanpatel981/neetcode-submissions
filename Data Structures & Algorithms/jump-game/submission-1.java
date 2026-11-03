class Solution {
    Boolean[] memo;
    private boolean dfs(int[] nums, int index) {

        if (index == nums.length - 1)
            return true;
        
        if (index >= nums.length)
            return false;

        if (memo[index] != null)
            return memo[index];

        
        boolean res;

        for (int j = 1; j <= nums[index]; j++) {
            res = dfs(nums, index + j);

            if (res) {
                memo[index] = true;
                return true;
            }
        }

        memo[index] = false;

        return false;
    }

    public boolean canJump(int[] nums) {
        memo = new Boolean[nums.length];
        return dfs(nums, 0);
    }
}
