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
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (level(root,xx,0) == level(root,yy,0)) && (!isSiblings(root,xx,yy));
    }

    public TreeNode findNode(TreeNode node, int x){
        if(node == null) return null;

        if(node.val == x) return node;

        TreeNode left = findNode(node.left,x);
        if(left != null) return left;
        
        return findNode(node.right,x);
    }

    public boolean isSiblings(TreeNode node, TreeNode x, TreeNode y){
        if(node == null) return false;

        return (node.left == x && node.right == y) || (node.left == y && node.right == x) ||isSiblings(node.left,x,y) || isSiblings(node.right,x,y);
    }

    public int level(TreeNode node, TreeNode x, int level){
        if(node == null) return 0;

        if(node == x) return level;

        int left = level(node.left,x,level+1);
        if(left != 0) return left;

        return level(node.right,x,level+1);
    }
}