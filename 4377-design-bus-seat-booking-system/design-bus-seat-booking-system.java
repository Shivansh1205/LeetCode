class BusBooking {
    private int[][] bus; 
    int time = 0; 
    int booked = 0; 
    public BusBooking(int n) {
        bus = new int[n + 1][4]; 
    }

    private int getRow(String seat) {
        return Integer.valueOf(seat.substring(1)); 
    }
    private int getCol(String seat) {
        return seat.charAt(0) - 'A'; 
    }

    private void unbook(int row, int col){
        time -= bus[row][col]; 
        booked--; 
        bus[row][col] = 0; 
    }

    private void book(int row, int col) {
        // window seat 
        int delay = 0; 
        if(col == 0) {
            if(bus[row][col + 1] > 0) delay += 2; 
        }
        if(col == 3) {
            if(bus[row][col-1]  > 0) delay += 2; 
        }
        bus[row][col] = 1 + delay; 
        time += 1 + delay; 
        booked++; 
    }
    
    public void toggle(String seat) {
        int r = getRow(seat); 
        int c = getCol(seat); 
        if(bus[r][c] > 0) unbook(r, c); 
        else book(r, c); 
    }
    
    public int getTotalTime() {
        return time; 
    }
    
    public int getMinTime() {
        return booked; 
    }
}

/**
 * Your BusBooking object will be instantiated and called as such:
 * BusBooking obj = new BusBooking(n);
 * obj.toggle(seat);
 * int param_2 = obj.getTotalTime();
 * int param_3 = obj.getMinTime();
 */