import java.math.BigInteger;
class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num.length() <=2) return false;
        for(int i=0;i<num.length()-1; i++){
            for(int j = i+1; j<num.length();j++){
                String s1 = num.substring(0,i+1);
                String s2 = num.substring(i+1,j+1);
                if((s1.length()>1 && s1.charAt(0) == '0') ||  (s2.length()>1 && s2.charAt(0) == '0')) continue;
                if(check(s1,s2,num.substring(j+1),2)) return true;
            }
        }
        return false;
    }
    private boolean check(String s1, String s2, String rem, int count){
         if(rem.isEmpty()) return count >= 3;
        //if(rem.isEmpty()) return true;
        BigInteger n1 = new BigInteger(s1);
        BigInteger n2 = new BigInteger(s2);
        String sum = (n1.add(n2)).toString();
        if(!rem.startsWith(sum)) return false;
        return check(s2,sum,rem.substring(sum.length()),count+1);
    }
}