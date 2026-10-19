class Solution {
    List<String> res;
    private void traverse(int n, int open, int close, StringBuilder sb) {
        if (open > n || close > n || close > open)
            return;
        
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        sb.append("(");
        traverse(n, open + 1, close, sb);
        sb.deleteCharAt(sb.length() - 1);
        
        sb.append(")");
        traverse(n, open, close + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

    }

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        traverse(n, 0, 0, new StringBuilder());
        return res;
    }
}
