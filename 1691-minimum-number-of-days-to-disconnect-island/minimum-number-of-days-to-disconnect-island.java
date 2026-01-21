class Solution {
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(countIslands(grid) != 1) return 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public int countIslands(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }

    public void dfs(int[][] matrix, int row, int col, int[][] visited){
        visited[row][col] = 1;
        int n = matrix.length;
        int m = matrix[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && matrix[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
                visited[nRow][nCol] = 1;
                dfs(matrix,nRow, nCol,visited);
            }
        }
    }
}