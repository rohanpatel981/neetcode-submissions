class Solution {
    private int res;

    private void dfs(int[] coins, int amt, int index, int c) { // 4 3 1
        if (amt < 0)
            return;
        if (amt == 0) {
            res = Math.min(res, c);
            return;
        }

        for (int i = index; i < coins.length;) {
            dfs(coins, amt - coins[i], i, c + 1);
            i++;
        }
    }

    public int coinChange(int[] coins, int amount) {
        coins = Arrays.stream(coins)
          .boxed()
          .sorted(Collections.reverseOrder())
          .mapToInt(Integer::intValue)
          .toArray();

        res = Integer.MAX_VALUE;
        dfs(coins, amount, 0, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}