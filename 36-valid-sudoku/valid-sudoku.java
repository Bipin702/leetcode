class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValid(board);
    }

    public boolean isValid(char[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char current = board[row][col];

                if(current != '.'){
                    board[row][col] = '.';
                    if(!isSafe(board,row,col,current)) return false;
                    board[row][col] = current;
                }
            }
        }
        return true;
    }

    public boolean isSafe(char[][] board, int row, int col, int digit){
        // check row;
        for(int i = 0; i < 9; i++){
            if(board[row][i] == digit) return false;
        }

        // check col
        for(int i = 0; i < 9; i++){
            if(board[i][col] == digit) return false;
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i = sr; i < sr+3; i++){
            for(int j = sc; j < sc+3; j++){
                if(board[i][j] == digit) return false;
            }
        }
        return true;
    }
}