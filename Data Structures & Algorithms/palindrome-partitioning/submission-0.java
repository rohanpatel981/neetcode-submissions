class Solution {
    private List<List<String>> res = new ArrayList<>();

    private void dfs(int start, String s, List<String> path) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
        }

        for (int end = start; end < s.length(); ++end) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                dfs(end + 1, s, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }

        return true;
    }

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        dfs(0, s, path);
        return res;
    }
}
