class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,arr,k,dp);
    }

    public int solve(int index, int[] arr,int k,int[] dp){
        int n = arr.length;
        if(index == n) return 0;
        if(dp[index] != -1) return dp[index];
        int count = 0;
        int max = Integer.MIN_VALUE;
        int maxAns = Integer.MIN_VALUE;
        for(int i = index; i < Math.min(n,index+k); i++){
            count++;
            max = Math.max(max,arr[i]);
            int sum = count*max + solve(i+1,arr,k,dp);
            maxAns = Math.max(sum,maxAns);
        }
        return dp[index] = maxAns;
    }
}