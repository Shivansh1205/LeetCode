class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder xc = new StringBuilder();
        StringBuilder yc = new StringBuilder();
        StringBuilder oth = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == y) yc.append(c);
            else if(c == x) xc.append(c);
            else oth.append(c);
        }
        return yc.append(xc).append(oth).toString();
    }
}