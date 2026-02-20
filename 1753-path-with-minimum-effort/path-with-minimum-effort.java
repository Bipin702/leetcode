class Solution {
    class Pair{
        int row;
        int col;
        int weight;

        Pair(int row, int col, int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] distance = new int[n][m];
        for(int[] row : distance){
            Arrays.fill(row,(int)1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight-b.weight);
        pq.add(new Pair(0,0,0));

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int r = p.row;
            int c = p.col;
            int diff = p.weight;

            if(r == n-1 && c == m-1) return diff;

            for(int i = 0; i < 4; i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                    int newEffort = Math.max(Math.abs(heights[nRow][nCol] - heights[r][c]),diff);
                    if(newEffort < distance[nRow][nCol]){
                    distance[nRow][nCol] = newEffort;

                    pq.add(new Pair(nRow,nCol,newEffort));
                    }

                }
            }
        }
        return 1;
    }
}