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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.end));
        List<Interval> list = new ArrayList<>();

        for (Interval x : intervals) {
            if (list.isEmpty()) {
                list.add(x);
            } else {
                if (list.get(list.size() - 1).end > x.start)
                    return false;
                list.add(x);
            }
        }

        return true;
    }
}
