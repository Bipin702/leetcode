class Solution {
    class Pair{
        int row;
        int col;
        int dist;

        Pair(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    visited[i][j] = 0;
                    q.offer(new Pair(i,j,0));
                }else{
                    visited[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair p = q.poll();
            int rows = p.row;
            int cols = p.col;
            int length = p.dist;

            distance[rows][cols] = length;

            for(int i = 0; i < 4; i++){
                int nRow = rows + delRow[i];
                int nCol = cols + delCol[i];

                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && visited[nRow][nCol] == 1){
                    visited[nRow][nCol] = 0;
                    q.offer(new Pair(nRow,nCol,length+1));
                }
            }
        }
        return distance;
    }
}