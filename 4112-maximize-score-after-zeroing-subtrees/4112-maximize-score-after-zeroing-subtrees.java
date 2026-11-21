class Solution {
    List<Integer>[] tree; 
    private int dfs(int u, int op[], int score[]) {
        int sm = 0, mn = Integer.MAX_VALUE; 
        for(int v: tree[u]) {
            int val = dfs(v, op, score); 
            sm += val; 
            mn = Math.min(mn, val); 
        }

        if(tree[u].isEmpty()) return score[u]; 

        return score[u] + sm - (op[u] == 1 ? mn: Math.min(0, mn)); 
    }
    public int maxScore(int[] parent, int[] op, int[] score) {

        int n = parent.length; 
        tree = new ArrayList[n]; 
        for(int i = 0; i < n; i++) tree[i] = new ArrayList<>(); 

        for(int i = 1; i < n; i++) tree[parent[i]].add(i); 
        return dfs(0, op, score); 
        
    }
}