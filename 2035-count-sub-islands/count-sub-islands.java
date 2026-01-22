class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        int[][] visited = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1 && visited[i][j] == 0){
                    if(dfs(grid1,grid2,i,j,visited))
                    count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int row, int col, int[][] visited){
        visited[row][col] = 1;
        int n = grid1.length;
        int m = grid1[0].length;
        boolean isIsland = true;
        if(grid1[row][col] == 0) isIsland = false;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid2[nRow][nCol] == 1){
                boolean result = dfs(grid1,grid2,nRow, nCol, visited);
                isIsland = isIsland && result;
            }
        }
        return isIsland;
    }
}