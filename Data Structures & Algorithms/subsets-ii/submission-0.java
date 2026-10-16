class Solution {
    Set<String> visited;
    List<List<Integer>> res;

    private void traverse(int[] nums, int index, List<Integer> temp) {
        if (index == nums.length) {
            StringBuilder s = new StringBuilder();
            for (int x : temp)
                s.append(String.valueOf(x)).append("-");
            
            if (!visited.contains(s.toString())) {
                visited.add(s.toString());
                res.add(new ArrayList<>(temp));
            }

            return;
        }

        temp.add(nums[index]);
        traverse(nums, index + 1, temp);
        temp.remove(temp.size() - 1);
        traverse(nums, index + 1, temp);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        visited = new HashSet<>();

        Arrays.sort(nums);

        traverse(nums, 0, new ArrayList<>());

        return res;
    }
}
