class Solution {
    public boolean isPalindrome(String s) {
        int N = s.length();

        StringBuilder c = new StringBuilder();

        for (char x : s.toLowerCase().toCharArray())
            if (x >= 'a' && x <= 'z' || x >= '0' && x <= '9')
                c.append(x);
        
        s = c.toString();
        for (int i = 0; i < s.length()/2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }
}
