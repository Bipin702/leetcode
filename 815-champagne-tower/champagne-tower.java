class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;

        for(int row = 0; row < query_row; row++){
            for(int col = 0; col <= row; col++){
                if(dp[row][col] > 1){
                    double overflow = (dp[row][col]-1)/2;

                    dp[row+1][col] += overflow;
                    dp[row+1][col+1] += overflow;
                    dp[row][col] = 1;
                }
            }
        }

        // for(double[] row : dp) Arrays.fill(row,-1);
        return Math.min(1.0,dp[query_row][query_glass]);
    }

    public double solve(int poured, int i, int j, double[][] dp){
        if(i == 0 && j == 0) return poured;
        if(i < 0 || j < 0 || i < j) return 0.0;
        if(dp[i][j] != -1) return dp[i][j];
        double leftUp = (solve(poured,i-1,j-1,dp)-1)/2.0;
        double rightUp = (solve(poured,i-1,j,dp)-1)/2.0;

        if(leftUp < 0) leftUp = 0.0;
        if(rightUp < 0) rightUp = 0.0;

        return dp[i][j] = leftUp + rightUp;
    }
}