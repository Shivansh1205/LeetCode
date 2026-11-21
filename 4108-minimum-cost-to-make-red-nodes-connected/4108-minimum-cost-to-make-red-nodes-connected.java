class Solution {
    List<Integer>[] g;
    int[] subSize;
    String colors = "";
    long[][] dp;
    public long minCost(int n, String colors, int[][] edges) {
        g = new ArrayList[n];
        subSize = new int[n];
        this.colors = colors;
        dp = new long[n][3];
        for(int i=0;i<n;i++)Arrays.fill(dp[i], -1l);
        
        for(int i=0;i<n;i++)g[i] = new ArrayList<>();
        for(int[] e: edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }

        helper(0, -1);
        return Math.min(dfs(0, -1, 0), Math.min(dfs(0, -1, 1), dfs(0, -1, 2)));
    }
    private void helper(int curr, int p){
        subSize[curr] = 1;
        for(int c: g[curr]){
            if(c==p)continue;
            helper(c, curr);
            subSize[curr]+=subSize[c];
        }
    }
    private long dfs(int curr, int p, int state){
        if(dp[curr][state]!=-1)return dp[curr][state];

        long cost = Long.MAX_VALUE/4;
        if(state==0){
            cost = colors.charAt(curr)=='R'?subSize[curr]:0;
            for(int child: g[curr]){
                if(child==p)continue;
                cost += dfs(child, curr, 0);
            }
        } else if(state == 1){
            cost = colors.charAt(curr)=='B'?subSize[curr]:0;
            for(int child: g[curr]){
                if(child==p)continue;
                cost += Math.min(dfs(child, curr, 0), dfs(child, curr, 1));
            }
        } else if(state == 2){
            long allB = dfs(curr, p, 0);
            long min = 0;
            for(int child: g[curr]){
                if(child==p)continue;
                min = allB - dfs(child, curr, 0) + Math.min(dfs(child, curr, 1), dfs(child, curr, 2));
                cost = Math.min(min, cost);
            }
        }
        return dp[curr][state] = cost;
    }
}