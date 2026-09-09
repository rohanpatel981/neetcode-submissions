class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        int[] res = new int[k];
        int index = 0;

        for (int i = 0; i < freq.length; ++i)
            freq[i] = new ArrayList<>();

        for (int x : nums)
            hmap.put(x, hmap.getOrDefault(x, 0) + 1);
        
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        for (int i = freq.length - 1; i > 0 && index < k; --i) {
            List<Integer> bucket = freq[i];

            for (int x : bucket) {
                res[index++] = x;

                if (index == k)
                    return res;
            }
        }

        return res;

    }
}
