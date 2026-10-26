class Solution {
    Map<String, Boolean> memo;
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        String key = String.valueOf(i) + "- " + j + "-" + k;
        if (memo.containsKey(key))
            return memo.get(key);

        if (k == s3.length())
            return i == s1.length() && j == s2.length();

        boolean res = false; // aabbbbaa
        if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
            res = res || dfs(s1, s2, s3, i + 1, j, k + 1);
        }

        if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
            res = res || dfs(s1, s2, s3, i, j + 1, k + 1);
        }

        memo.put(key, res);

        return res;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new HashMap<>();
        return dfs(s1, s2, s3, 0, 0, 0);
    }
}
