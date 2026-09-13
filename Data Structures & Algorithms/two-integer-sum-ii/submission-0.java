class Solution {
    public int[] twoSum(int[] num, int target) {
        int N = num.length;

        for (int i = 0, j = N - 1; i < j; ) {
            if (num[i] + num[j] == target) 
                return new int[]{i + 1, j + 1};
            else if (num[i] + num[j] > target)
                j--;
            else
                i++;
        }
        return null;
    }
}
