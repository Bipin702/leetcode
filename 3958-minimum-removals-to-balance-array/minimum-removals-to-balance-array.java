class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        Arrays.sort(nums);
        int maxLength = Integer.MIN_VALUE;
        for(int right = 0; right < n; right++){
            while (nums[right] > (long) k * nums[left]) {
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);
        }
        return n-maxLength;
    }
}