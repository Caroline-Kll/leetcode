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
    int res;
    int sum;
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        sum = 0;
        dfs(root);
        return res;
        
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        sum = root.val + left + right;
        res = Math.max(sum, res);
        return root.val + Math.max(left, right);
    }
}
