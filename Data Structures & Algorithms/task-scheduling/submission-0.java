class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int maxF = 0, countMax = 0;

        for (char c : tasks) {
            count[c - 'A']++;
            maxF = Math.max(maxF, count[c - 'A']);
        }
        
        for (int i = 0; i < 26; ++i)
            if (maxF == count[i])
                countMax++;
        
        return Math.max(tasks.length, (maxF - 1)*(n + 1) + countMax);

    }
}
