class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int N = piles.length, total = 0;
        int _max = Integer.MIN_VALUE;
        int low = 1, high;

        for (int x : piles)
            _max = Math.max(_max, x);
        
        high = _max;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int time = 0;

            for (int x : piles)
                time += Math.ceil((double) x/mid);
            
            if (h >= time) {
                total = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return total;
    }
}
