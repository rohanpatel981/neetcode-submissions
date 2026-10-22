class Solution {
    Map<String, Integer> memo;

    private int dfs(int[] coins, int amount, int index) {

        if (amount < 0 || index >= coins.length)
            return Integer.MAX_VALUE;

        StringBuilder key = new StringBuilder();
        key.append("").append(index).append("-").append(amount);
        
        if (memo.containsKey(key.toString()))
            return memo.get(key.toString());
        
        if (amount == 0)
            return 0;
        

        int res = Integer.MAX_VALUE;

        int take = dfs(coins, amount - coins[index], index);
        int leave = dfs(coins, amount, index + 1);

        if (take != Integer.MAX_VALUE)
            take += 1;

        res = Math.min(res, Math.min(take, leave));
        memo.put(key.toString(), res);
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        memo = new HashMap<>();
        int res = dfs(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
