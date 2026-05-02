import java.util.Arrays;

class Solution {
    public double[] internalAngles(int[] sides) {

        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        // Triangle validity
        if (a + b <= c || a + c <= b || b + c <= a) {
            return new double[0];
        }

        double[] ans = new double[3];

        ans[0] = Math.toDegrees(Math.acos(clamp((b*b + c*c - a*a) / (2.0*b*c))));
        ans[1] = Math.toDegrees(Math.acos(clamp((a*a + c*c - b*b) / (2.0*a*c))));
        ans[2] = Math.toDegrees(Math.acos(clamp((a*a + b*b - c*c) / (2.0*a*b))));

        // ✅ sort ascending
        Arrays.sort(ans);

        return ans;
    }

    private double clamp(double x) {
        return Math.max(-1.0, Math.min(1.0, x));
    }
}