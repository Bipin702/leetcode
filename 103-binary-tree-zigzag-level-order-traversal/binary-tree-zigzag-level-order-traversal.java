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
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        boolean reversed = false;

        while(!dq.isEmpty()){
            int n = dq.size();
            List<Integer> res = new ArrayList<>();

            for(int i = 0; i < n; i++){
                if(!reversed){
                    TreeNode curr = dq.removeFirst();
                    res.add(curr.val);
                    if(curr.left != null) dq.addLast(curr.left);
                    if(curr.right != null) dq.addLast(curr.right);
                }else{
                    TreeNode curr = dq.removeLast();
                    res.add(curr.val);
                    if(curr.right != null) dq.offerFirst(curr.right);
                    if(curr.left != null) dq.offerFirst(curr.left);
                }
            }
            reversed = !reversed;
            ans.add(res);
        }
        return ans;
    }
}