class Solution {
    class Pair{
        int row;
        int col;
        int difference;

        Pair(int row, int col, int difference){
            this.row = row;
            this.col = col;
            this.difference = difference;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.difference - b.difference);
        pq.offer(new Pair(0,0,0));
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int rows = p.row;
            int cols = p.col;
            int diff = p.difference;

            if(rows == n-1 && cols == m-1) return diff;

            for(int i = 0; i < 4; i++){
                int nRow = rows + delRow[i];
                int nCol = cols + delCol[i];

                if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0){
                    int effort = Math.max(Math.abs(heights[rows][cols] - heights[nRow][nCol]),diff);
                    if(dist[nRow][nCol] > effort){
                        dist[nRow][nCol] = effort;
                        pq.offer(new Pair(nRow,nCol,effort));
                    }
                }
            }
        }
        return 0;
    }
}