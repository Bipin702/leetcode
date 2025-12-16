class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for(int[] row : prerequisites){
            int u = row[0];
            int v = row[1];
            adj.get(v).add(u);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            for(int neighbor : adj.get(i)){
                indegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int count = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neighbor : adj.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    q.add(neighbor);
                }
            }
        }
        if(count == numCourses) return true;
        return false;
    }
}