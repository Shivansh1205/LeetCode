class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        int m = classroom[0].length();

        char[][] arr = new char[n][m];

        int sx = -1, sy = -1;
        int litterCount = 0;

        // Store grid and locate S + count litter
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = classroom[i].charAt(j);

                if (arr[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (arr[i][j] == 'L') {
                    litterCount++;
                }
            }
        }

        // All litter already collected
        if (litterCount == 0) {
            return 0;
        }

        int fullMask = (1 << litterCount) - 1;

        // Give every litter cell a bit number
        int[][] litterId = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                litterId[i][j] = -1;
            }
        }

        int id = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'L') {
                    litterId[i][j] = id++;
                }
            }
        }

        /*
         * State:
         * x, y       -> current position
         * e          -> remaining energy
         * mask       -> collected litter
         */

        class State {
            int x, y, e, mask, dist;

            State(int x, int y, int e, int mask, int dist) {
                this.x = x;
                this.y = y;
                this.e = e;
                this.mask = mask;
                this.dist = dist;
            }
        }

        Queue<State> q = new ArrayDeque<>();

        /*
         * visited[x][y][energy][mask]
         *
         * energy ranges from 0..energy
         * mask ranges from 0..2^litterCount
         */
        boolean[][][][] visited =
            new boolean[n][m][energy + 1][1 << litterCount];

        q.offer(new State(sx, sy, energy, 0, 0));
        visited[sx][sy][energy][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            State cur = q.poll();

            // Collected everything
            if (cur.mask == fullMask) {
                return cur.dist;
            }

            /*
             * If energy == 0, we cannot make another move.
             * Being on R does not magically allow movement unless
             * the reset happens when we arrive at R.
             */
            if (cur.e == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                // Outside grid
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                // Obstacle
                if (arr[nx][ny] == 'X') {
                    continue;
                }

                // One move costs one energy
                int ne = cur.e - 1;

                // Collect litter
                int nmask = cur.mask;

                if (arr[nx][ny] == 'L') {
                    int litterIndex = litterId[nx][ny];
                    nmask |= (1 << litterIndex);
                }

                // Reset energy when entering R
                if (arr[nx][ny] == 'R') {
                    ne = energy;
                }

                // Avoid repeated states
                if (!visited[nx][ny][ne][nmask]) {
                    visited[nx][ny][ne][nmask] = true;

                    q.offer(new State(
                        nx,
                        ny,
                        ne,
                        nmask,
                        cur.dist + 1
                    ));
                }
            }
        }

        return -1;
    }
}