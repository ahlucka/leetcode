import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int writeIndex = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[writeIndex][1] >= intervals[i][0]) {
                intervals[writeIndex][1] = Math.max(intervals[writeIndex][1], intervals[i][1]);
            } else {
                writeIndex++;
                intervals[writeIndex] = intervals[i];
            }
        }

        return Arrays.copyOf(intervals, writeIndex + 1);
    }
}