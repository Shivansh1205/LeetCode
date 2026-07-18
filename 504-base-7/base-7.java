class Solution {
    public String convertToBase7(int num) {
        if(num==0)
        {
            return "0";
        }
        boolean negative=false;
        if(num<0)
        {
            negative=true;
            num=Math.abs(num);
        }
        StringBuilder ans=new StringBuilder();
        while(num>0)
        {
            ans.append(num%7);
            num=num/7;
        }
        if(negative)
        {
            ans.append("-");
        }
        return ans.reverse().toString();
    }
}