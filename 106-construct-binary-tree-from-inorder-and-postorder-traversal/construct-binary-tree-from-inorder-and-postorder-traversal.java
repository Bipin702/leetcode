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
        int n = inorder.length;
        
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) map.put(inorder[i],i);

        return helper(inorder,0,n-1,postorder,0,n-1,map);
    }

    public TreeNode helper(int[] inorder,int inStart, int inEnd, int[] postorder, int postStart, int postEnd,HashMap<Integer,Integer> map){
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = helper(inorder,inStart,inRoot-1,postorder,postStart,postStart+numsLeft-1,map);

        root.right = helper(inorder,inRoot+1,inEnd,postorder,postStart+numsLeft,postEnd-1,map);

        return root;
    }
}