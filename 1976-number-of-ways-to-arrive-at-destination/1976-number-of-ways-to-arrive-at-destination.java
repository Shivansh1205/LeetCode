import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {

        int mod = (int)1e9 + 7;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : roads) {
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair cur = pq.poll();

            int node = cur.node;
            long currDist = cur.dist;

            if (currDist > dist[node]) continue;

            for (Pair p : adj.get(node)) {

                int next = p.node;
                long newDist = currDist + p.dist;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.offer(new Pair(next, newDist));
                }
                else if (newDist == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }

        return (int) ways[n - 1];
    }
}

class Pair {
    int node;
    long dist;

    Pair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}