class Solution {
    class Pair{
        int row;
        int col;
        int time;

        Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = 2;
                }else{
                    visited[i][j] = 0;
                }

                if(grid[i][j] == 1) countFresh++;
            }
        }

        int count = 0;
        int tm = 0;

        while(!q.isEmpty()){
            Pair p = q.poll();
            int rows = p.row;
            int cols = p.col;
            int t = p.time;
            tm = Math.max(tm,t);

            for(int i = 0; i < 4; i++){
                int nRow = rows + delRow[i];
                int nCol = cols + delCol[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
                    q.add(new Pair(nRow,nCol,t+1));
                    visited[nRow][nCol] = 2;
                    count++;
                }
            }
        }
        if(count != countFresh) return -1;
        return tm;
    }
}