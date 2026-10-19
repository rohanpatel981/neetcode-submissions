class Solution {
    List<List<Integer>> res;

    private void dfs(int[] nums, boolean[] pick, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (!pick[i]) {
                pick[i] = true;
                temp.add(nums[i]);
                dfs(nums, pick, temp);
                temp.remove(temp.size() - 1);
                pick[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
}
