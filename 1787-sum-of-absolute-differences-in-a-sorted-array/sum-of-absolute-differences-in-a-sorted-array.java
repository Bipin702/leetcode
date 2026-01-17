class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for(int i = 1; i <= n; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        for(int i = 0; i < n;i++){
            result[i] = nums[i]*i - prefix[i] + (prefix[n] - prefix[i+1]) - nums[i]*(n-i-1);
        }
        return result;
    }
}