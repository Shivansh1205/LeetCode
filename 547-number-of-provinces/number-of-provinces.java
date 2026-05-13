class Solution {
    public int findCircleNum(int[][] adj) {
        int V = adj.length;
        List<List<Integer>> adjls = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjls.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj[i][j] == 1 && i!=j){
                    adjls.get(i).add(j);
                    adjls.get(j).add(i);
                }
            }
        }
        int cnt=0;
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                cnt++;
                dfs(i,adjls,vis);
            }
        }
        return cnt;
    }
    private void dfs(int node, List<List<Integer>> adjls, int[] vis){
        vis[node] =1;
        for(Integer it : adjls.get(node)){
            if(vis[it]!=1) dfs(it,adjls,vis);
        }
    }
}