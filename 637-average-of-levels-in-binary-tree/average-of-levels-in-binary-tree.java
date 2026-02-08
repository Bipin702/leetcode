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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            double average = 0;
            int n = q.size();

            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();
                average += curr.val;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            average = average/n;
            ans.add(average);
        }
        return ans;
    }
}