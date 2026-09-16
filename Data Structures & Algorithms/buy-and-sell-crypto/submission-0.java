class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length, res = 0;
        int low = prices[0], high = prices[0];

        for (int i = 1; i < N; ++i) {
            if (prices[i] < low) {
                low = prices[i];
                high = prices[i];
                continue;
            }

            high = Math.max(high, prices[i]);

            res = Math.max(res, high - low);
        }

        return res;
    }
}
