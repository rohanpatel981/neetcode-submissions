class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        int res = 0;
        
        for (int x : nums)
            numSet.add(x);
        
        for (int x : numSet) {
            if (!numSet.contains(x - 1)) {
                int len = 1;
                while (numSet.contains(x + len))
                    len++;
                res = Math.max(res, len);
            }
        }

        return res;
    }
}
