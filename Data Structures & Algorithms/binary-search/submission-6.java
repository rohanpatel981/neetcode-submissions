class Solution {
    public int search(int[] nums, int target) {
        int N = nums.length;

        if (N == 1 && nums[0] == target)
            return 0;

        int low = 0, high = N - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        
        return -1;
    }
}
