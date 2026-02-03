class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited = new int[n][m];

        for(int i = 0; i < m; i++){
            //first row
            if(visited[0][i] == 0 && board[0][i] == 'O'){
                dfs(0,i,visited,board);
            }

            //last row
            if(visited[n-1][i] == 0 && board[n-1][i] == 'O'){
                dfs(n-1,i,visited,board);
            }
        }

        for(int i = 0; i < n; i++){
            if(visited[i][0] == 0 && board[i][0] == 'O'){
                dfs(i,0,visited,board);
            }

            if(visited[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i,m-1, visited,board);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row, int col, int[][] visited, char[][] board){
        visited[row][col] = 1;

        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                dfs(nRow, nCol,visited,board);
            }
        }
    }
}