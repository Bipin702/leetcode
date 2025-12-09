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
    public TreeNode insertIntoBST(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
                                                      
        if (value < node.val) {
            node.left = insertIntoBST(node.left, value);
        } else if (value > node.val) {
            node.right = insertIntoBST(node.right, value);
        }

        return node;
    }
}