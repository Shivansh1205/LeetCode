/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int mini = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return mini;
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);
        if(prev!= null){
            mini = Math.min(mini,node.val-prev.val);
        }
        prev=node;
        inorder(node.right);
    }
}