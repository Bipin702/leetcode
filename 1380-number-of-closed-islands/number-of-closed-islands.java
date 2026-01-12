class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0 && visited[i][j] == 0){
                    if(dfs(grid,i,j,visited)) count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int row, int col, int[][] visited){
        int n = grid.length;
        int m = grid[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m) return false;

        if(grid[row][col] == 1 || visited[row][col] == 1) return true;

        visited[row][col] = 1;

        boolean left = dfs(grid,row,col-1,visited);
        boolean right = dfs(grid,row,col+1,visited);
        boolean up = dfs(grid,row-1,col,visited);
        boolean down = dfs(grid,row+1,col,visited);

        return left && right && up && down;
    }
}