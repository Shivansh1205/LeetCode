class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = getMax(piles);
        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            int hours = value(piles, mid);
            
            if (hours <= h) {
                ans = mid;          // possible answer
                high = mid - 1;     // try smaller speed
            } else {
                low = mid + 1;      // need faster speed
            }
        }

        return ans;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }

    public int value(int[] piles, int k) {
        int total = 0;
        for (int pile : piles) {
            total += Math.ceil((double) pile / k);  // correct type conversion
        }
        return total;
    }
}
