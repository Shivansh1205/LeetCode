class Robot {
    int[] pos;
    int[][] step;
    int dir;
    int width, height;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        pos = new int[]{0, 0};
        step = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        dir = 0;
    }
    
    public void step(int num) {
        int perimeter = 2 * (width + height - 2);
        num %= perimeter;

        // special edge case
        if (num == 0 && pos[0] == 0 && pos[1] == 0) {
            dir = 3; // South
            return;
        }

        while (num > 0) {
            int nx = pos[0] + step[dir][0];
            int ny = pos[1] + step[dir][1];

            if (nx >= 0 && nx < width && ny >= 0 && ny < height) {
                pos[0] = nx;
                pos[1] = ny;
                num--;
            } else {
                dir = (dir + 1) % 4;
            }
        }
    }
    
    public int[] getPos() {
        return pos;
    }
    
    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}