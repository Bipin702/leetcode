class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 1) count++;
            }
            pq.offer(new int[]{i,count});
        }
        int[] result = new int[k];
        int index = 0;
        while(index < k){
            int[] p = pq.poll();
            result[index] = p[0];
            index++;
        }
        return result;
    }
}