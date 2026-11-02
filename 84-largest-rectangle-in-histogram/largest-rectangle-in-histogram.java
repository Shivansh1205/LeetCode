import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] nse = new int[n];
        int[] pse = new int[n];

        oneshot(nse, pse, heights);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public void oneshot(int[] nse, int[] pse, int[] nums) {

        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() &&
                   nums[st.peek()] >= nums[i]) {

                int eleidx = st.pop();
                nse[eleidx] = i;
            }

            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek();
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            int eleidx = st.pop();
            nse[eleidx] = n;
        }
    }
}