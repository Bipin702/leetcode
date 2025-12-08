/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer,TreeNode> parent = new HashMap<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(node.left != null){
                    q.offer(node.left);
                    parent.put(node.left.val,node);
                }

                if(node.right != null){
                    q.offer(node.right);
                    parent.put(node.right.val,node);
                }
            }
        }

            HashMap<Integer,Integer> visited = new HashMap<>();
            q.offer(target);
            while(k > 0 && !q.isEmpty()){
                int size = q.size();

                for(int i = 0; i < size; i++){
                    TreeNode node = q.poll();
                    visited.put(node.val,1);
                    if(node.left != null && !visited.containsKey(node.left.val)){
                        q.offer(node.left);
                    }

                    if(node.right != null && !visited.containsKey(node.right.val)){
                        q.offer(node.right);
                    }

                    if(parent.containsKey(node.val) && !visited.containsKey(parent.get(node.val).val)){
                        q.offer(parent.get(node.val));
                    }
                }
                k--;
            }
            while(!q.isEmpty()){
                result.add(q.poll().val);
        }
        return result;
    }
}