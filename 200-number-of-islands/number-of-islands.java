class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    count++;
                    dfs(grid,i,j,visited);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col, int[][] visited){
        visited[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == '1' && visited[nRow][nCol] == 0){
                dfs(grid,nRow, nCol, visited);
            }
        }
    }
}