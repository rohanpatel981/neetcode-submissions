class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int count;
    public KthLargest(int k, int[] nums) {
        for (int x : nums)
            pq.offer(x);
        
        count = k;
    }
    
    public int add(int val) {
        List<Integer> l = new ArrayList<>();
        int c = count;
        pq.offer(val);

        while (!pq.isEmpty() && c > 1) {
            l.add(pq.poll());
            c--;
        }

        int res = pq.isEmpty() ? 0 : pq.peek();

        for (int x : l)
            pq.offer(x);
        
        return res;
    }
}
