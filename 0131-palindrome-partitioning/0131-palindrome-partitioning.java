class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res,s,new ArrayList<>(),0);
        return res;
    }
    public void backtrack(List<List<String>> res, String s, List<String> cur, int ind){
        if(ind == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = ind; i<s.length();i++){
            String sub = s.substring(ind,i+1);
            if(palindrome(sub)){
                cur.add(sub);
                backtrack(res,s,cur,i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    public boolean palindrome(String s){
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left ++;
            right--;
        }
        return true;
    }
}