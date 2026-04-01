class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        
        // Step 1: store robots with index
        int[][] robots = new int[n][4]; // pos, health, dir, index
        
        for(int i = 0; i < n; i++){
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            robots[i][2] = directions.charAt(i); // 'L' or 'R'
            robots[i][3] = i;
        }
        
        // Step 2: sort by position
        Arrays.sort(robots, (a,b) -> a[0] - b[0]);
        
        Stack<int[]> st = new Stack<>();
        
        for(int[] robot : robots){
            if(robot[2] == 'R'){
                st.push(robot);
            } else {
                while(!st.isEmpty() && st.peek()[2] == 'R'){
                    if(st.peek()[1] < robot[1]){
                        robot[1]--; 
                        st.pop();
                    }
                    else if(st.peek()[1] > robot[1]){
                        st.peek()[1]--;
                        robot[1] = 0;
                        break;
                    }
                    else {
                        st.pop();
                        robot[1] = 0;
                        break;
                    }
                }
                
                if(robot[1] > 0){
                    st.push(robot);
                }
            }
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        for(int[] r : st){
            result[r[3]] = r[1];
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int val : result){
            if(val != -1) ans.add(val);
        }
        
        return ans;
    }
}