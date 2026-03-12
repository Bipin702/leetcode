class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }

    public int solve(int index,int[] dp){
        if(index == 0 || index == 1) return 1;

        if(dp[index] != -1) return dp[index];

        dp[index] = solve(index-1, dp) + solve(index-2 , dp);
        return dp[index];
    }
}