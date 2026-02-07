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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;

        int n = inorder.length;
        int m = postorder.length;

        int r = postorder[m-1];

        int index = 0;

        for(int i = 0; i < n; i++){
            if(inorder[i] == r) index = i;
        }

        TreeNode root = new TreeNode(r);

        root.left = buildTree(Arrays.copyOfRange(inorder,0,index),Arrays.copyOfRange(postorder,0,index));

        root.right = buildTree(Arrays.copyOfRange(inorder,index+1,n),Arrays.copyOfRange(postorder,index,m-1));

        return root;
    }
}