class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(u).add(v);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int node : adj.get(i)) indegree[node]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                q.add(neighbor);
            }
        }
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] != 0) return false;
        }
        return true;
    }
}