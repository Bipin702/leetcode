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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        buildGraph(root,null,graph);

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int time = -1;
        q.offer(start);
        visited.add(start);

        while(!q.isEmpty()){
            int size = q.size();
            time++;

            for(int i = 0; i < size; i++){
                int node = q.poll();

                for(int neighbor : graph.get(node)){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
        }
        return time;
    }

    public void buildGraph(TreeNode node, TreeNode parent, Map<Integer,List<Integer>> graph){
        if(node == null) return;

        graph.putIfAbsent(node.val,new ArrayList<>());

        if(parent != null){
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        if(node.left != null){
            graph.get(node.val).add(node.left.val);
            graph.putIfAbsent(node.left.val,new ArrayList<>());
            graph.get(node.left.val).add(node.val);
        }

        if(node.right != null){
            graph.get(node.val).add(node.right.val);
            graph.putIfAbsent(node.right.val,new ArrayList<>());
            graph.get(node.right.val).add(node.val);
        }

        buildGraph(node.left,node,graph);
        buildGraph(node.right,node,graph);
    }
}