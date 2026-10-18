class Solution {
    private List<String> res = new ArrayList<>();

    private void traverse(int index, String digits, String[] data, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char d = digits.charAt(index);
        for (int j = 0; j < data[digits.charAt(index) - '0'].length(); ++j) {
            char c = data[d - '0'].charAt(j);
            sb.append(c);
            traverse(index + 1, digits, data, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new ArrayList<>();

        String[] data = populate(digits);
        Map<String, String> visited = new HashMap<>();
        traverse(0, digits, data, new StringBuilder());
        return res;
    }

    private String[] populate(String digits) {
        String[] data = new String[10];
        for (char c : digits.toCharArray()) {
            if (c == '2') {
                data[c - '0'] = "abc";
            }
            if (c == '3') {
                data[c - '0'] = "def";
            }
            if (c == '4') {
                data[c - '0'] = "ghi";
            }
            if (c == '5') {
                data[c - '0'] = "jkl";
            }
            if (c == '6') {
                data[c - '0'] = "mno";
            }
            if (c == '7') {
                data[c - '0'] = "pqrs";
            }
            if (c == '8') {
                data[c - '0'] = "tuv";
            }
            if (c == '9') {
                data[c - '0'] = "wxyz";
            }
        }
        return data;
    }
}
