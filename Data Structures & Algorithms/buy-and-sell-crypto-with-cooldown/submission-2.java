class Solution {
    Map<String, Integer> memo;
    private int dfs(int[] prices, int index, int curr, boolean bought) {

        if (index >= prices.length)
            return 0;

        String key = String.valueOf(index) + bought + curr;

        if (memo.containsKey(key))
            return memo.get(key);

        int buy = 0, sell = 0, skip = 0;
        if (!bought) {
            buy = dfs(prices, index + 1, curr + prices[index], true);
        }
        else if (prices[index] > curr && bought){
            sell = (prices[index] - curr) + dfs(prices, index + 2, 0, false);
        }

        skip = dfs(prices, index + 1 , curr, bought);

        memo.put(key, Math.max(skip, Math.max(buy, sell)));
        return memo.get(key);
    }

    public int maxProfit(int[] prices) {
        memo = new HashMap<>();
        return dfs(prices, 0, 0, false);
    }
}
