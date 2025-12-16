class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        for(int[] edge : prerequisites){
            int u = edge[0];
            int v = edge[1];
            adj.get(v).add(u);
        }
        int[] indegree = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            for(int node : adj.get(i)){
                indegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }
        
        int[] result = new int[numCourses];
        int i = 0;
        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            result[i++] = node;
            
            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        if(count != numCourses) return new int[]{};
        return result;
    }
}