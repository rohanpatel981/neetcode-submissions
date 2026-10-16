class Solution {
    List<List<Integer>> res;

    private void traverse(int[] nums, int index, List<Integer> temp) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        traverse(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
        traverse(nums, index + 1, temp);
    }

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        traverse(nums, 0, temp);

        return res;
    }
}
