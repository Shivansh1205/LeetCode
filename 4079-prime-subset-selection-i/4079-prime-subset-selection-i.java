class Solution {
    static int MAX = 1_000_001;
    static int[] prime = new int[MAX];
    static {
        generatePrime();
    }
    static final void generatePrime() {
        prime[0] = prime[1] = 1;

        for (int i = 2; i * i < MAX; i++) {
            if (prime[i] == 1) continue;

            for (int j = i * i; j < MAX; j += i) {
                prime[j] = 1;
            }
        }
    }
    public List<Integer> maxPrimes(int n, int s) {

        List<Integer> ans = new ArrayList<>(); 
        if(s < 2) return ans; 
        for(int i = 1; i <= n && s >= 0; i++) {
            if(i <= s && prime[i] == 0) {
                s-= i; 
                ans.add(i); 
            }
        }
        return ans;
    }
}