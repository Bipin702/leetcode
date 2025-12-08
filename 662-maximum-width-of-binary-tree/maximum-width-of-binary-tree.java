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
    class Pair{
        TreeNode node;
        int value;

        Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root,0));
        int maxWidth = 0;

        while(!q.isEmpty()){
            int levelSize = q.size();
            int levelStart = q.peek().value;
            int index = 0;

            for(int i = 0; i < levelSize; i++){
                Pair p = q.poll();
                TreeNode newNode = p.node;
                index = p.value;

                if(newNode.left != null) q.offer(new Pair(newNode.left,2*index));
                if(newNode.right != null) q.offer(new Pair(newNode.right,2*index+1));
            }
        maxWidth = Math.max(maxWidth,index-levelStart+1);
        }
        return maxWidth;
    }
}