class Solution {
    public int maxUniqueSplit(String s) {
        int ans = f(0,s,new HashSet<String>());
        return ans;
    }
    private int f(int start, String s, HashSet<String> seen){
        if(start == s.length()) return 0;
        int maxlen=0;
        for(int end = start +1; end<=s.length(); end++){
            String sub = s.substring(start,end);
            if(!seen.contains(sub)){
                seen.add(sub);
                maxlen = Math.max(maxlen,1+f(end,s,seen));
                seen.remove(sub);
            }
        }
        return maxlen;
    }
}