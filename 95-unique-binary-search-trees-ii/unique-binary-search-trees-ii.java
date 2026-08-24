class Solution {
    public List<TreeNode> generateTrees(int n) {
        return f(1, n);
    }

    private List<TreeNode> f(int s, int end) {
        List<TreeNode> res = new ArrayList<>();

        // No nodes
        if (s > end) {
            res.add(null);
            return res;
        }

        // Try every value as the root
        for (int i = s; i <= end; i++) {

            List<TreeNode> lefts = f(s, i - 1);
            List<TreeNode> rights = f(i + 1, end);

            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode cur = new TreeNode(i, l, r);
                    res.add(cur);
                }
            }
        }

        return res;
    }
}