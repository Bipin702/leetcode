class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);

        int minimum = Integer.MAX_VALUE;

        for(int i = 0; i <= n-k; i++){
            int current = nums[i+k-1] - nums[i];
            minimum = Math.min(minimum,current);
        }

        return minimum;
    }
}