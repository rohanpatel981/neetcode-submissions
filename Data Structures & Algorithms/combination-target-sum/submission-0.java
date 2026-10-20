class Solution {
    List<List<Integer>> res;

    private void dfs(int[] nums, int index, List<Integer> temp, int k, int sum) {
        if (index >= nums.length)
            return;
        
        if (sum == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (sum > k) 
            return;
        
        temp.add(nums[index]);
        dfs(nums, index, temp, k, sum + nums[index]);
        temp.remove(temp.size() - 1);
        dfs(nums, index + 1, temp, k, sum);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), target, 0);
        return res;
    }
}
