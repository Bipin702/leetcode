class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int count = 0;

        //check 1 in first row and lasr row
        for(int i = 0; i < m; i++){
            //1st row
            if(grid[0][i] == 1 && visited[0][i] == 0){
                dfs(0,i,grid,visited);
            }

            //last row
            if(grid[n-1][i] == 1 && visited[n-1][i] == 0){
                dfs(n-1,i,grid,visited);
            }
        }

        //check for first col and last col
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1 && visited[i][0] == 0){
                dfs(i,0,grid,visited);
            }

            if(grid[i][m-1] == 1 && visited[i][m-1] == 0){
                dfs(i,m-1,grid,visited);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }
        
        return count;
    }

    public void dfs(int row, int col, int[][] grid, int[][] visited){
        visited[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
                dfs(nRow, nCol,grid,visited);
            }
        }
    }
}