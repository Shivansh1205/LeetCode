class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder t=new StringBuilder();
        int n = s.length();
        for(int i =0; i<n; i++){
            char c = s.charAt(i);
            if((c>='A'&&c<='Z')||(c>='a'&&c<='z')||(c>='0' && c<='9')) {
                t.append(Character.toLowerCase(c));
            }
        }
        return helper(0,t.length()-1,t);
    }
    public boolean helper(int s, int f, StringBuilder m){
        if(s>=f){
            return true;
        }
        if (m.charAt(s) != m.charAt(f)) {
            return false;
        }
        return helper(s+1,f-1,m);

        

    }
}