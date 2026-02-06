class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(char[] row : board){
            Arrays.fill(row,'.');
        }

        solve(0,board,ans);
        return ans;
    }

    public void solve(int row, char[][] board, List<List<String>> ans){
        if(row == board.length){
            List<String> res = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                res.add(new String(board[i]));
            }
            ans.add(res);
            return;
        }

        for(int col = 0; col < board.length; col++){
            if(isSafe(board,row,col)){
                board[row][col] = 'Q';
                solve(row+1,board,ans);
                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(char[][] board,int row, int col){
        // top row
        for(int i = row-1; i >= 0; i--){
            if(board[i][col] == 'Q') return false;
        }

        //left vertical
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }

        //right vertical
        for(int i = row-1, j = col+1; i >= 0 && j < board.length; i--,j++){
            if(board[i][j] == 'Q') return false;
        }

        return true;
    }
}