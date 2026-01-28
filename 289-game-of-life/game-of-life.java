class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[] dirRow ={-1, -1, -1, 0, +1, +1, +1, 0};
        int[] dirCol ={-1, 0, +1, +1, +1, 0, -1, -1};

        int[][] next = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int count = 0;

                for(int d = 0; d < 8; d++){
                    int nRow = i + dirRow[d];
                    int nCol = j + dirCol[d];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m){
                        if(board[nRow][nCol] == 1) count++;
                    }
                }

                if(board[i][j] == 1){
                    if(count == 2 || count == 3) next[i][j] = 1;
                }else{
                    if(count == 3) next[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                board[i][j] = next[i][j];
            }
        }
    }
}