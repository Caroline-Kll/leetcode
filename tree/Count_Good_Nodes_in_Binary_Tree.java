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
    int max;
    
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        res = 0;
        max = root.val;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        // System.out.println("curr node: "+root.val);
        int currMax = max;
        if (root.val >= max) {
            res++;
            // System.out.println("max: "+root.val);
            max = root.val;
        }

        if (root.left != null) dfs(root.left);
        if (root.right != null) dfs(root.right);
        max = currMax;
    } 
}
