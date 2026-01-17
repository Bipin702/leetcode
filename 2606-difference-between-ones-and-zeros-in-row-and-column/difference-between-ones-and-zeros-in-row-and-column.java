class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] onesRow = new int[n];
        int[] onesCol = new int[m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    onesRow[i] += 1;
                    onesCol[j] += 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int zeroRow = n - onesRow[i];
                int zeroCol = m - onesCol[j];

                grid[i][j] = onesRow[i] + onesCol[j] - zeroRow - zeroCol;
            }
        }
        return grid;
    }
}