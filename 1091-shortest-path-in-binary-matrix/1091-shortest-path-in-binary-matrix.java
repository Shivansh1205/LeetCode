class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dis = new int[n][n];
        for (int[] row : dis)
            Arrays.fill(row, Integer.MAX_VALUE);

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(1, 0, 0));
        dis[0][0] = 1;

        while (!q.isEmpty()) {
            Tuple cur = q.poll();

            int dist = cur.dis;
            int row = cur.row;
            int col = cur.col;

            if (row == n - 1 && col == n - 1)
                return dist;

            for (int i = 0; i < 8; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 && dist + 1 < dis[nr][nc]) {

                    dis[nr][nc] = dist + 1;
                    q.offer(new Tuple(dist + 1, nr, nc));
                }
            }
        }

        return -1;
    }
}

class Tuple {
    int dis, row, col;

    Tuple(int dis, int row, int col) {
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}