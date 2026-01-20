class Solution {
    public int[][] findFarmland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        List<int[]> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    int[] bounds = dfs(grid,i,j,visited);
                    result.add(bounds);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[] dfs(int[][] grid, int row, int col, int[][] visited){
        visited[row][col] = 1;
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{row,col});

        int n = grid.length;
        int m = grid[0].length;

        int minRow = row;
        int minCol = col;
        int maxRow = row;
        int maxCol = col;

        while(!st.isEmpty()){
            int[] current = st.pop();
            int curRow = current[0];
            int curCol = current[1];

            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,1,0,-1};

            for(int i = 0; i < 4; i++){
                int nRow = curRow + delRow[i];
                int nCol = curCol + delCol[i];

                if(nRow >=  0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    st.push(new int[]{nRow,nCol});
                    minRow = Math.min(minRow, nRow);
                    minCol = Math.min(minCol,nCol);
                    maxRow = Math.max(maxRow, nRow);
                    maxCol = Math.max(maxCol, nCol);
                }
            }
        }
        return new int[]{minRow,minCol,maxRow,maxCol};
    }
}