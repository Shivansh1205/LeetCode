class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        f(s,0,ans, new StringBuilder());
        return ans;
    }
    private void f(String s, int idx, List<String> ans, StringBuilder res){
        if(idx == s.length()) {
            ans.add(res.toString());
            return;
        }
        char c = s.charAt(idx);
        if(Character.isLetter(c)){
            res.append(Character.toLowerCase(c));
            f(s,idx+1,ans,res);
            res.deleteCharAt(res.length()-1);

            res.append(Character.toUpperCase(c));
            f(s,idx+1,ans,res);
            res.deleteCharAt(res.length()-1);
        }
        else{
            res.append(c);
            f(s,idx+1,ans,res);  
            res.deleteCharAt(res.length()-1);
        }
        
    }
}