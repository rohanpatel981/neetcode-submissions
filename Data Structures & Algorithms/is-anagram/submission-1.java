class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char x : s.toCharArray())
            map.put(x, map.getOrDefault(x, 0) + 1);
        
        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) - 1);

            if (map.get(x) < 0)
                return false;
            if (map.get(x) == 0)
                map.remove(x);
        }
        return map.size() == 0 ? true : false;
    }
}
