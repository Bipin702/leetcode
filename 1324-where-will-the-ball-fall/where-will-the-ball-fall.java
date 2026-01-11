class Solution {
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid == null || n == 0) return new int[0];
        int[] ans = new int[m];

        for(int ball = 0; ball < m; ball++){
            int row = 0;
            int col = ball;

            while(row < n && col < m){
                if(grid[row][col] == 1 && col+1 < m && grid[row][col+1] == 1){
                    col++;
                    row++;
                }else if(grid[row][col] == -1 && col - 1 >= 0 && grid[row][col-1] == -1){
                    col--;
                    row++;
                }else{
                    break;
                }
            }
            ans[ball] = row == n ? col : -1;
        }
        return ans;
    }
}