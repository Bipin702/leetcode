class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;
        int[] dp = new int[n+1];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            int take = nums[i];
            if(i > 1) take += dp[i-2];
            int notTake = dp[i-1];

            dp[i] = Math.max(take,notTake);
        }
        return dp[n-1];
        // Arrays.fill(dp,-1);
        // return solve(n-1,nums,dp);
    }

    public int solve(int index, int[] nums,int[] dp){
        if(index == 0) return nums[0];
        if(index < 0) return 0;
        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + solve(index-2,nums,dp);
        int notPick = solve(index-1,nums,dp);

        return dp[index] = Math.max(pick,notPick);
    }
}