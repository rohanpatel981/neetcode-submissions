class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low)/2;

            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[low]) { //left
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else { //right
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }


        }

        return nums[low] == target ? low : -1;
    }
}
