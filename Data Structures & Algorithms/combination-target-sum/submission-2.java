class Solution {
    List<List<Integer>> res;

    private void dfs(int[] nums, int index, List<Integer> temp, int k) {
        if (index >= nums.length || k < 0)
            return;
        
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(nums[index]);
        dfs(nums, index, temp, k - nums[index]);
        temp.remove(temp.size() - 1);
        dfs(nums, index + 1, temp, k);
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), target);
        return res;
    }
}
