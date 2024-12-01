class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        long temp = x;
        long reverse = 0;
        while(temp != 0){
            int dig = (int) (temp %10);
            reverse = reverse * 10 + dig;
            temp /= 10;
        }
        return(reverse==x);
        
    }
}