class Solution {
    private int getMax(Map<Character, Integer> map) {
        int res = 0;
        for (int x : map.values())
            res = Math.max(res, x);
        return res;
    }

    public int characterReplacement(String s, int k) {
        int N = s.length();
        Map<Character, Integer> countMap = new HashMap<>();
        int maxf = 0, res = 0;

        for (int i = 0, back = 0; i < N; ++i) { // AAZZZAAZZ
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            maxf = getMax(countMap);

            while ((i - back + 1) - maxf > k) {
                countMap.put(s.charAt(back), countMap.get(s.charAt(back)) - 1);
                back++;
            }

            res = Math.max(res, (i - back + 1));
        }

        return res;
    }
}
