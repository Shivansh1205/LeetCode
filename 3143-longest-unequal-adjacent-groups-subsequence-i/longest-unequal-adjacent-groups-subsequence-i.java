class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> s  = new ArrayList<>(); 
        int last =  -1;
        for(int i=0;i<words.length;i++){
            if(last != groups[i]){
                s.add(words[i]);
                last = groups[i];
            }
        }
        return s;
    }
}