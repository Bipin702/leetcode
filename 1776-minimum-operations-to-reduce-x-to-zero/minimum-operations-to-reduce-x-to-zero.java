class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int sum = 0;
        for(int num : nums) sum += num;

        int target = sum-x;
        if(target < 0) return -1;
        int maxLen = -1;
        int left = 0;
        int currentSum = 0;

        for(int right = 0; right < n; right++){
            currentSum += nums[right];

            while(currentSum > target && left <= right){
                currentSum -= nums[left];
                left++;
            }

            if(currentSum == target){
                maxLen = Math.max(maxLen, right-left+1);
            }
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}