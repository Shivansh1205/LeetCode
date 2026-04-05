class Solution {
    public boolean judgeCircle(String moves) {
        int hor=0;
        int ver=0;
        for(char c:moves.toCharArray()){
            if(c=='R') hor++;
            else if(c=='L') hor--;
            else if(c=='U') ver++;
            else ver--;
        }
        if(hor==0 && ver==0) return true;
        return false;
    }
}