class Solution {
    Set<String> visited;
    List<List<Integer>> res;

    private void traverse(int[] nums, int index, List<Integer> temp) {
        if (index == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        traverse(nums, index + 1, temp);
        temp.remove(temp.size() - 1);

        int next = index + 1;

        while (next < nums.length && nums[next] == nums[next - 1]) {
            next++;
        }

        traverse(nums, next, temp);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        visited = new HashSet<>();

        Arrays.sort(nums);

        traverse(nums, 0, new ArrayList<>());

        return res;
    }
}
