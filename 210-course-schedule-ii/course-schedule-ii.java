class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] pre : prerequisites){
            int u = pre[0];
            int v = pre[1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int neighbor : adj.get(i)) indegree[neighbor]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] ans = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }
        int index = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[index] = node;
            index++;
            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0)
                q.add(neighbor);
            }
        }
        if(index != numCourses) return new int[0];
        
        return ans;
    }
}