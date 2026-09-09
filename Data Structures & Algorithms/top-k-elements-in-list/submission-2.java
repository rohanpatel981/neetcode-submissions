class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, Integer> hmap = new HashMap<>();

        for (int x : nums) {
            hmap.put(x, hmap.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
            if (heap.size() > k)
                heap.poll();
        }

        for (int i = 0; i < k; ++i)
            res[i] = heap.poll()[1];
        
        return res;
    }
}
