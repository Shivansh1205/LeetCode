class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] e : prerequisites) {
            int course = e[0];
            int prereq = e[1];

            adj.get(prereq).add(course);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            for(int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[numCourses];
        int idx = 0;

        while(!q.isEmpty()) {
            int node = q.poll();

            topo[idx++] = node;

            for(int it : adj.get(node)) {
                indegree[it]--;

                if(indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        if(idx != numCourses) {
            return new int[0];
        }

        return topo;
    }
}