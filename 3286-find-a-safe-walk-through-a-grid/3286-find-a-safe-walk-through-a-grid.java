import java.util.*;

class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] vis = new int[n][m];
        for (int[] row : vis) Arrays.fill(row, -1);

        Queue<pair> q = new LinkedList<>();

        int s = health - grid.get(0).get(0);
        if (s <= 0) return false;

        q.add(new pair(0, 0, s));
        vis[0][0] = s;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            pair p = q.poll();

            int r = p.row;
            int c = p.col;
            int hea = p.heal;

            if (r == n - 1 && c == m - 1) return true;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {

                    if (grid.get(nr).get(nc) == 0) {

                        if (vis[nr][nc] < hea) {
                            vis[nr][nc] = hea;
                            q.add(new pair(nr, nc, hea));
                        }

                    } else {

                        if (hea > 1 && vis[nr][nc] < hea - 1) {
                            vis[nr][nc] = hea - 1;
                            q.add(new pair(nr, nc, hea - 1));
                        }

                    }
                }
            }
        }

        return false;
    }
}

class pair {
    int heal;
    int row;
    int col;

    public pair(int row, int col, int heal) {
        this.row = row;
        this.col = col;
        this.heal = heal;
    }
}