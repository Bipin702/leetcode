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
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        StringBuilder path = new StringBuilder();
        helper(root, path, result);
        return result;
    }

    private void helper(TreeNode node, StringBuilder path, List<String> result){
        if(node == null) return;
        int len = path.length();

        if (path.length() != 0) path.append("->");
        path.append(node.val);

        if(node.left == null && node.right == null){
            result.add(path.toString());
        }else{
            helper(node.left, path, result);
            helper(node.right,path,result);
        }
        path.setLength(len);
    }
}