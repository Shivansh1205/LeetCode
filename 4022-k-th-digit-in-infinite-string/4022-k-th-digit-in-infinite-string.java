class Solution {
    public int kthDigit(long k){
        if(k<=9)return (int)k;
        long[] v=new long[18];
        long p=1,sum=0;
        for(int i=1;i<=16;i++){
            sum+=9*p*i; 
            v[i]=sum;
            p*=10;
        }
        int idx=0;
        for(int i=0;i<v.length;i++){
            if(v[i]>=k){
                idx=i; 
                break;
            }
        }
        k-=v[idx-1]; 
        k--; 
        long num=k/idx,d=k%idx;
        long b=1;
        for(int i=0;i<idx-1;i++)b*=10; 
        long val=b+num;
        long bb=val/10;
        if(bb%2==1){
            val=bb*10+(9-(val%10));
        }
        String res=Long.toString(val);
        return res.charAt((int)d)-'0'; 
    }
}