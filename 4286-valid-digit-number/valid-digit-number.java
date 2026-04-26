class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char ch = (char)(x+'0');
        if(s.charAt(0) == ch) return false;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i) == ch) return true;
        }
        return false;
    }
}