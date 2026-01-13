class Solution {
    public int countNegatives(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int count = 0;
       int i = n-1;
       int j = 0;
        while(i >= 0 && j < m){
            if(grid[i][j] >= 0){
                j++;
            }else{
                count += m-j;
                i--;
            }
        }
        return count;
    }
}