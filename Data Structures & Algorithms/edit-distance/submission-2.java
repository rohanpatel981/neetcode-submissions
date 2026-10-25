class Solution {
    int[][] memo;

    private int dfs(String word1, String word2, int i, int j) {
        // If word1 is exhausted, insert all remaining characters of word2.
        if (i == word1.length())
            return word2.length() - j;

        // If word2 is exhausted, delete all remaining characters of word1.
        if (j == word2.length())
            return word1.length() - i;

        // Reuse the cached answer.
        if (memo[i][j] != -1)
            return memo[i][j];

        // Matching characters need no operation.
        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = dfs(word1, word2, i + 1, j + 1);
        }

        // INSERT: insert word2[j] into word1.
        int insert = 1 + dfs(word1, word2, i, j + 1);

        // DELETE: delete word1[i].
        int delete = 1 + dfs(word1, word2, i + 1, j);

        // REPLACE: replace word1[i] with word2[j].
        int replace = 1 + dfs(word1, word2, i + 1, j + 1);

        // Choose the operation with minimum cost.
        return memo[i][j] = Math.min(insert, Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];

        for (int[] row : memo) Arrays.fill(row, -1);

        return dfs(word1, word2, 0, 0);
    }
}
