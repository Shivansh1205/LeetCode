class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int sum =0;
        int curr =9;
        for(int i=1;i<=n;i++){
            sum+= curr;
            curr = curr*(9-i+1); 
        }
        return sum+1;
    }
}