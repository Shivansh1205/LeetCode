class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            // Build histogram for current row
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, largestHistogram(height));
        }

        return maxArea;
    }

    private int largestHistogram(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : nums[i];

            while (!st.isEmpty() && nums[st.peek()] > currHeight) {
                int height = nums[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, height * (right - left - 1));
            }

            st.push(i);
        }

        return maxArea;
    }
}