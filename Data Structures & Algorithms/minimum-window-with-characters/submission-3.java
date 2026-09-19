class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tmap = new HashMap<>();
        HashMap<Character, Integer> smap = new HashMap<>();
        String res = "";

        for (char c : t.toCharArray()) tmap.put(c, tmap.getOrDefault(c, 0) + 1);

        for (int left = 0, right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            smap.put(c, smap.getOrDefault(c, 0) + 1);

            while (left <= right && contains(smap, tmap)) {
                if (res.isEmpty() || res.length() > right - left + 1)
                    res = s.substring(left, right + 1);
                smap.put(s.charAt(left), smap.getOrDefault(s.charAt(left), 1) - 1);

                if (smap.get(s.charAt(left)) == 0)
                    smap.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

    private boolean contains(HashMap<Character, Integer> smap, HashMap<Character, Integer> tmap) {
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if (!smap.containsKey(entry.getKey()) || smap.get(entry.getKey()) < entry.getValue())
                return false;
        }
        return true;
    }
}
