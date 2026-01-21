class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;

        int[][] matrix = new int[n*3][n*3];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i].charAt(j) == '/'){
                    matrix[i*3][j*3+2] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3] = 1;
                }

                if(grid[i].charAt(j) == '\\'){
                    matrix[i*3][j*3] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3+2] = 1;
                }
            }
        }

        int[][] visited = new int[n*3][n*3];
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0 && visited[i][j] == 0){
                    dfs(matrix,i,j,visited);
                    count++;
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

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && matrix[nRow][nCol] == 0 && visited[nRow][nCol] == 0){
                visited[nRow][nCol] = 1;
                dfs(matrix,nRow, nCol,visited);
            }
        }
    }
}