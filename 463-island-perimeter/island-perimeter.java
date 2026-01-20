class Solution {
    int count = 0;
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    dfs(grid,i,j,visited);
                    return count;
                }
            }
        }
        return 0;
    }

    public void dfs(int[][] grid, int row, int col, int[][] visited){
        visited[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow ={-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= n || nRow < 0 || nCol >= m || nCol < 0 || grid[nRow][nCol]==0){
                count++;
            }

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                dfs(grid,nRow,nCol,visited);
            }
        }
    }
}