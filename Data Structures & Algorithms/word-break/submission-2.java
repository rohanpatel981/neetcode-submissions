class Solution {
    Set<String> set;
    Map<String, Boolean> memo;

    private boolean dfs(String s, int index, StringBuilder curr) { // aaaaaaa
        if (index >= s.length())
            return false;

        String key = String.valueOf(index) + curr.toString();

        if (memo.containsKey(key))
            return memo.get(key);

        curr.append(s.charAt(index));

        if (set.contains(curr.toString()) && index == s.length() - 1) {
            return true;
        }

        boolean res = false;

        if (set.contains(curr.toString()))
            res = res || dfs(s, index + 1, new StringBuilder());

        res = res || dfs(s, index + 1, curr);
        memo.put(key, res);
        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new HashMap<>();
        return dfs(s, 0, new StringBuilder());
    }
}
