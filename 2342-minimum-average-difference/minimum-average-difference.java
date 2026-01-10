class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long min = Long.MAX_VALUE;
        int index = 0;

        long sum = 0;
        for (int num : nums) sum += num;

        long leftSum = 0;

        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            long rightSum = sum - leftSum;

            long leftAvg = leftSum / (i + 1);
            long rightAvg = (i == n - 1) ? 0 : rightSum / (n - i - 1);

            long diff = Math.abs(leftAvg - rightAvg);

            if (diff < min) {
                min = diff;
                index = i;
            }
        }
        return index;
    }
}
