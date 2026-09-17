class Solution {

    private boolean checkDuplicate(int[] count) {

        for (int i = 0; i < count.length; ++i)
            if (count[i] > 1)
                return true;
        
        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int N = s.length(), res = 0;

        for (int i = 0, j = 0; i < N; ++i) {
            char x = s.charAt(i);
            count[x]++;

            while(j < i && checkDuplicate(count)) {
                count[s.charAt(j)]--;
                j++;
            }

            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}
