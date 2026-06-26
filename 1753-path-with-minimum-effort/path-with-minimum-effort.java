class tuple {
    int dist, row, col;

    public tuple(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int[][] dis = new int[n][m];
        for (int[] row : dis)
            Arrays.fill(row, Integer.MAX_VALUE);

        dis[0][0] = 0;
        pq.offer(new tuple(0, 0, 0));

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {
            tuple cur = pq.poll();

            int dist = cur.dist;
            int row = cur.row;
            int col = cur.col;

            if (row == n - 1 && col == m - 1)
                return dist;

            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int dif = Math.abs(heights[row][col] - heights[nr][nc]);
                    int newEffort = Math.max(dist, dif);

                    if (newEffort < dis[nr][nc]) {
                        dis[nr][nc] = newEffort;
                        pq.offer(new tuple(newEffort, nr, nc));
                    }
                }
            }
        }

        return 0;
    }
}