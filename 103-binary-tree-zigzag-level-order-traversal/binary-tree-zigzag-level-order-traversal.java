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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean reversed = false;
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> ans = new ArrayList<>();

            for(int i = 0; i < levelSize; i++){
                if(!reversed){
                    TreeNode current = q.pollFirst();
                    ans.add(current.val);
                    if(current.left != null) q.offerLast(current.left);
                    if(current.right != null) q.offerLast(current.right);
                }else{
                    TreeNode current = q.pollLast();
                    ans.add(current.val);
                    if(current.right != null) q.offerFirst(current.right);
                    if(current.left != null) q.offerFirst(current.left);
                }
            }
            reversed = !reversed;
            result.add(ans);
        }
        return result;
    }
}