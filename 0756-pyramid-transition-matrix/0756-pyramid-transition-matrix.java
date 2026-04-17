class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
    List<Character>[][] map = new List[6][6];
    Map<String, Boolean> memo = new HashMap<>();
    
    for (String al : allowed) {
        int a = al.charAt(0) - 'A';
        int b = al.charAt(1) - 'A';
        if (map[a][b] == null) map[a][b] = new ArrayList<>();
        map[a][b].add(al.charAt(2));
    }
    
    return dfs(bottom.toCharArray(), map, memo);
}
private boolean dfs(char[] row, List<Character>[][] map, Map<String, Boolean> memo) {
    int n = row.length;
    if (n == 1) return true;  // → We've reached the top of the pyramid!
    
    String key = new String(row);
    if (memo.containsKey(key)) return memo.get(key);  // → Already know if this row works or not
    
    List<char[]> nextRows = new ArrayList<>();
    getNextRows(row, map, 0, new char[n-1], nextRows);  // → Generate all possible rows above this one
    
    for (char[] next : nextRows) {
        if (dfs(next, map, memo)) {  // → Try to build from this next row
            memo.put(key, true);  // → Success! Remember that this row can lead to the top
            return true;
        }
    }
    
    memo.put(key, false);  // → None of the possible next rows worked
    return false;
}
private void getNextRows(char[] row, List<Character>[][] map, int idx, 
                        char[] current, List<char[]> result) {
    if (idx == row.length - 1) {  // → We've filled all positions in the next row
        result.add(current.clone());  // → Add a copy of this complete next row
        return;
    }
    
    int a = row[idx] - 'A';  // → Convert left block to array index
    int b = row[idx + 1] - 'A';  // → Convert right block to array index
    
    if (map[a][b] == null) return;  // → No rules for this pair, dead end
    
    for (char c : map[a][b]) {  // → Try every possible block that could go on top
        current[idx] = c;  // → Put this block in position 'idx' of the next row
        getNextRows(row, map, idx + 1, current, result);  // → Fill the rest of the row
    }
}
}