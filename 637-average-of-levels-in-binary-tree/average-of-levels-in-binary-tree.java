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
        List<Double> result = new ArrayList<>();
        if(root == null) return null;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            double average = 0;
            int levelSize = q.size();
            
            for(int i = 0; i < levelSize; i++){
                TreeNode current = q.poll();
                average += current.val;

                if(current.left != null) q.offer(current.left);
                if(current.right != null) q.offer(current.right);
            }
            average = average/levelSize;
            result.add(average);
        }
        return result;
    }
}