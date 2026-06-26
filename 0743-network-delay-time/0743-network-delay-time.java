class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, k});
        for(int[] e : times){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
        }
        int[] dist = new int[n+1];
        
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        while(!pq.isEmpty()){
            int[] e = pq.poll();
            int time = e[0];
            int node = e[1];
            for(int[] cur : adj.get(node)){
                int next = cur[0];
                int nexttime = cur[1];
                if(dist[next]>time+nexttime){
                    dist[next] = time+nexttime;
                    pq.add(new int[]{time+nexttime,next});
                }
            }
        }
        int ans =-1;
        for(int i=1;i<dist.length;i++){
            ans = Math.max(ans,dist[i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}