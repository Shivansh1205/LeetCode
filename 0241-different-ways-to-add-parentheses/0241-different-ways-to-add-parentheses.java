class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return f(expression);
    }
    private List<Integer> f(String s){
        List<Integer> res= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='+'||s.charAt(i) == '-' || s.charAt(i) == '*'){
                List<Integer> left = f(s.substring(0,i));
                List<Integer> right = f(s.substring(i+1,s.length()));

                for(int l : left){
                    for(int r : right){
                        if(s.charAt(i) == '+') res.add(l+r);
                        else if(s.charAt(i) == '-') res.add(l-r);
                        else res.add(l*r);
                    }
                }
            }
        }
         if (res.isEmpty()) {
            res.add(Integer.parseInt(s));
        }
        return res;
    }
}