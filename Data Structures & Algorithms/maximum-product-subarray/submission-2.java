class Solution {
    public int maxProduct(int[] nums) {
        int maxE, minE, ans;

        maxE = minE = ans = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            int x = nums[i];

            if (x < 0) {
                int temp = maxE;
                maxE = minE;
                minE = temp;
            }

            maxE = Math.max(maxE * x, x);
            minE = Math.min(minE * x, x);

            ans = Math.max(ans, maxE);
        }

        return ans;
    }
}
