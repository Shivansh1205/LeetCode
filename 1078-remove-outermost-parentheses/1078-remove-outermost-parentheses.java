class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb  = new StringBuilder();
        int cnt =0;
        boolean add = false;
        for(char c : s.toCharArray()){
            if(c == '('){
                cnt++;
            }
            else if(c == ')'){
                cnt--;
            }
            if(cnt == 2 && c == '('){
                add=true;
            }
            else if(cnt == 0 && c ==')' ){
                add = false;
            }

            if(add){
                sb.append(c);
            }

        }
        return sb.toString();
    }
    
}