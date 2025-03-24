import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        // Step 1: Sort meetings by start day
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Merge overlapping meetings
        int busyDays = 0;
        int start = -1, end = -1;

        for (int[] meeting : meetings) {
            int s = meeting[0], e = meeting[1];

            if (s > end) { // No overlap, count previous interval
                busyDays += end - start + 1;
                start = s;
                end = e;
            } else { // Overlapping, extend end
                end = Math.max(end, e);
            }
        }

        // Add last interval
        busyDays += end - start + 1;

        // Step 3: Return free days
        return days - busyDays+1;
    }
}
