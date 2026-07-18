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
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> res = new ArrayList<>();
        if(root != null) {
            dfs(root, "", res);
        }
        return res;
    }
    private void dfs(TreeNode root,String path,List<String> res){
       if(path.isEmpty()){
           path += root.val;
       }else{
           path += "->"+root.val;
       }
       if(root.left == null && root.right == null){
           res.add(path);
           return;
       }
       if(root.left != null){
           dfs(root.left,path,res);
       }
       if(root.right != null){
           dfs(root.right,path,res);
       }
    }
}