class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        generate(res,0,0,n,"");
        return res;
    }
    public void generate(List<String> res,int left,int right,int n,String current){
        if(current.length() == n*2){
            res.add(current);
            return;
        }
        if(left<n){
            generate(res,left+1,right,n,current+"(");
        }
        if(right<left){
            generate(res,left,right+1,n,current+")");
        }
    }
}