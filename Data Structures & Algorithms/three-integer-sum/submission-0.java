class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int N = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < N - 2; ++i) { // -4 -1 -1 0 1 2
            if (i != 0 && nums[i - 1] == nums[i])
                continue;
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return res;
    }
}
