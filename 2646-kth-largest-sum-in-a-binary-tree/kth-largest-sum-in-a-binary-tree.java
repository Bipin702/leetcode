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
    int sum = 0;
    public long kthLargestLevelSum(TreeNode root, int k) {
        if(root == null) return 0;
        List<Long> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        // long maxSum = 0;
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                sum += node.val;

                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(sum);
        }
        if(k > res.size()) return -1;
        res.sort(Collections.reverseOrder());
        return res.get(k-1);
    }
}