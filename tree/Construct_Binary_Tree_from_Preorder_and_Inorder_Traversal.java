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
    Map<Integer, Integer> map;
    int pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        pre = 0;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return construct(preorder, inorder, 0, preorder.length);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int start, int end) {
        if (pre >= preorder.length || start > end) return null;
        int curr = preorder[pre];
        pre++;
        TreeNode root = new TreeNode(curr);
        int idx = map.get(curr);
        root.left = construct(preorder, inorder, start, idx-1);
        root.right = construct(preorder, inorder, idx+1, end);
        return root;
    }


}
