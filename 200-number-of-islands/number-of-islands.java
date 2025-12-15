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
                    dfs(i,j,visited,grid);
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, int[][] visited, char[][] grid){
        visited[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int d = 0; d < 4; d++){
            int nRow = row + delRow[d];
            int nCol = col + delCol[d];

            if(nRow >= 0 && nRow < n && nCol >=0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
                dfs(nRow,nCol,visited,grid);
            }
        }
    }
}