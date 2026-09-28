/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0)
            return 0;

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Interval x : intervals) {
            if (pq.isEmpty()) {
                pq.offer(x.end);
            } else {
                if (!pq.isEmpty() && x.start >= pq.peek()) {
                    pq.poll();
                }
                pq.offer(x.end);
            }
        }

        return pq.size();
    }
}
