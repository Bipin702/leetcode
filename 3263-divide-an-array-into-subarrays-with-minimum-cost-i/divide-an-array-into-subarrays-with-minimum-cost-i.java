class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;

        int i = 0;

        for(int j = 1; j < n-1; j++){
            int sum = 0;
            for(int k = j+1; k < n; k++){
                sum = nums[i] + nums[j] + nums[k];
                minSum = Math.min(sum,minSum);
            }
        }
        return minSum;
    }
}