class Solution {
    Map<String, Integer> memo;
    private int dfs(int[] coins, int amount, int index, int sum) {
        String key = String.valueOf(index) + "-" + sum;

        if (memo.containsKey(key))
            return memo.get(key);

        if (sum == amount)
            return 1;

        if (index == coins.length)
            return 0;

        if (sum > amount)
            return 0;

        int take = dfs(coins, amount, index, sum + coins[index]);
        int leave = dfs(coins, amount, index + 1, sum);

        memo.put(key, take + leave);

        return take + leave;
    }

    public int change(int amount, int[] coins) {
        memo = new HashMap<>();
        return dfs(coins, amount, 0, 0);
    }
}
