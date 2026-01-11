class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int currMax = 0;
        int totalSum = 0;
        int minSum = nums[0];
        int currMin = 0;

        for(int num : nums){
            currMax = Math.max(num, currMax+num);
            maxSum = Math.max(currMax, maxSum);

            currMin = Math.min(num, currMin+num);
            minSum = Math.min(currMin, minSum);

            totalSum += num;
        }

        // if all numbers are negative
        if(maxSum < 0) return maxSum;

        return Math.max(maxSum, totalSum-minSum);
    }
}