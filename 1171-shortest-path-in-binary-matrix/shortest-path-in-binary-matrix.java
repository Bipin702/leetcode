class Solution {
    class Pair{
        int weight;
        int row;
        int col;
        
        Pair(int weight,int row, int col){
            this.weight = weight;
            this.row = row;
            this.col = col; 
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        if (n == 1 && m == 1 && grid[0][0] == 0) return 1;

        Queue<Pair> q = new LinkedList<>();
        
        int[][] dist = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                dist[i][j] = (int) 1e9;
            }
        }

        dist[0][0] = 1;

        q.add(new Pair(1,0,0));

         while(!q.isEmpty()){
            Pair p = q.poll();
            int dis = p.weight;
            int r = p.row;
            int c = p.col;
            
           for(int delRow = -1; delRow <= 1; delRow++){
                for(int delCol = -1; delCol <= 1; delCol++){
                int nRow = r + delRow;
                int nCol = c + delCol;
                
                if(nRow >=0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 0 && dis+1 < dist[nRow][nCol]){
                    dist[nRow][nCol] = dis+1;
                    if(nRow == n-1 && nCol == m-1) return dis+1;
                    q.add(new Pair(dis+1,nRow,nCol));
                }
            }
        }
         }
        return -1;
    }
}