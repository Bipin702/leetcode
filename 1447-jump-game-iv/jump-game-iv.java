class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        
        boolean[] visited = new boolean[n];
        visited[0] = true;

        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i] , k -> new ArrayList<>()).add(i);
        }

        int steps = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int index = q.poll();

                if(index == n-1) return steps;

                if(index - 1 >= 0 && !visited[index-1]){
                    visited[index-1] = true;
                    q.offer(index-1);
                }

                if(index + 1 < n && !visited[index+1]){
                    visited[index+1] = true;
                    q.offer(index+1);
                }

                if(map.containsKey(arr[index])){
                    for(int k : map.get(arr[index])){
                        if(!visited[k]){
                            visited[k] = true;
                            q.offer(k);
                        }
                    }
                map.remove(arr[index]);
                }
            }
            steps++;
        }
        return steps;
    }
}