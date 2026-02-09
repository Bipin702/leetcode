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
    public TreeNode balanceBST(TreeNode node){
        List<Integer> val = new ArrayList<>();
        inorder(node,val);
        return balance(val,0,val.size()-1);
    }

    public void inorder(TreeNode node, List<Integer> val){
        if(node == null) return;

        inorder(node.left,val);
        val.add(node.val);
        inorder(node.right,val);
    }

    public TreeNode balance(List<Integer> val, int start, int end){
        int mid = start + (end - start)/2;
        if(start > end) return null;
        TreeNode root = new TreeNode(val.get(mid));
        root.left = balance(val,start,mid-1);
        root.right = balance(val,mid+1,end);
        return root;
    }
}