class Solution {
    int getColor(char c) {
        if(c == 'R') return 0; 
        if(c == 'B') return 1; 
        return 2; 
    }
    public int findColoredRoot(int[][] edges, String colors) {
        int n = colors.length(); 
        int ind[] = new int[n]; 
        int oud[] = new int[n]; 

        for(int i = 0; i < n - 1; i++) {
            int u = edges[i][0]; 
            int v = edges[i][1]; 
            int cu = getColor(colors.charAt(u)); 
            int cv = getColor(colors.charAt(v)); 

            if(cu == cv) return -1; 
            if((cv - cu + 3)%3 == 1) {
                oud[u]++; 
                ind[v]++; 
            } else {
                // connect v -> u 
                oud[v]++; 
                ind[u]++; 
            }
        }
        int root = -1; 

        for(int i = 0; i < n; i++) { 
            if(oud[i] > 2 || ind[i] > 1) return -1; 
            if(ind[i] == 0) {
                if(root != -1) return -1;
                root = i; 
            }
        }
        return root; 
    }
}