class Solution {
    public int rob(TreeNode root) {
        int[] ans = f(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] f(TreeNode root) {

        if (root == null)
            return new int[]{0, 0};

        int[] left = f(root.left);
        int[] right = f(root.right);

        // Rob current node
        int rob = root.val + left[1] + right[1];

        // Don't rob current node
        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }
}