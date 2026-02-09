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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;

        return CreateBst(nums,0,n-1);
    }

    public TreeNode CreateBst(int[] nums, int start, int end){
        int n = nums.length;
        if(start > end) return null;
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = CreateBst(nums,start,mid-1);
        root.right = CreateBst(nums,mid+1,end);

        return root;
    }
}