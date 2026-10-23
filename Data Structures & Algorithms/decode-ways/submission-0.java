class Solution {
    Map<Integer, Integer> memo;

    private boolean inRange(String v) {
        int n = Integer.valueOf(v);
        return n >= 1 && n <= 26 && v.charAt(0) != '0';
    }

    private int dfs(String s, int index) { // 12
        int N = s.length();
        int one, two; 
        one = two = 0;

        if (memo.containsKey(index))
            return memo.get(index);

        if (index == N)
            return 1;

        if (index < N && inRange(s.substring(index, index + 1))) {
            one = dfs(s, index + 1);
        }

        if (index < N - 1 && inRange(s.substring(index, index + 2))) {
            two = dfs(s, index + 2);
        }
        memo.put(index, one + two);
        return one + two;
    }

    public int numDecodings(String s) {
        memo = new HashMap<>();
        return dfs(s, 0);
    }
}
