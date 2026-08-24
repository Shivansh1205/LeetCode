class Solution {
    public int numTrees(int n) {
        int[] uni = new int[n+1];
        Arrays.fill(uni,1);
        for(int nodes = 2; nodes<=n;nodes++){
            int tot =0;
            for(int root=1;root<=nodes;root++){
                tot+= uni[root-1]*uni[nodes-root];
            }
            uni[nodes] = tot;

        }
        return uni[n];
    }
}