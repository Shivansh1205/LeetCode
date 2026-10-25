
import java.util.*;

class Solution {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int l = 0; l < n; l++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            ArrayList<Integer> order = new ArrayList<>();

            for (int r = l; r < n; r++) {
                int x = nums[r];

                if (!freq.containsKey(x)) {
                    freq.put(x, 0);
                    order.add(x);
                }

                freq.put(x, freq.get(x) + 1);

                boolean valid = true;

                for (int i = 0; i < order.size(); i++) {
                    if (freq.get(order.get(i)) != i + 1) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
