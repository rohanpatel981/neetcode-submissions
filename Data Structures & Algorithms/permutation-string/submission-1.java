class Solution {
    private boolean same(int[] a, int[] b) {
        for (int i = 0; i < 26; i++)
            if (a[i] != b[i])
                return false;
        return true;
    }

    private boolean extraChar(int[] a, int[] count) {
        for (int i = 0; i < a.length; ++i)
            if (a[i] > count[i])
                return true;
        return false;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        int[] c = new int[26];

        for (char x : s1.toCharArray())
            count[x - 'a']++;
        
        for (int i = 0, back = 0; i < s2.length(); i++) {
            char x = s2.charAt(i);
            c[x - 'a']++;

            if (i - back + 1 == s1.length()) {
                if (same(c, count)) return true;
                while (i > back && extraChar(c, count)) {
                    c[s2.charAt(back++) - 'a']--;
                }
            }
        }
        return false;
    }
}
