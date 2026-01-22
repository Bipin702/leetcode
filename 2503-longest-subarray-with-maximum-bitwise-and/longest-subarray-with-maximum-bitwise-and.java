class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxVal = 0;
        int length = 0;
        int maxLength = 0;

        for(int num : nums){
            if(num > maxVal){
                maxVal = num;
                length = 0;
                maxLength = 0;
            }

            if(num == maxVal){
                length++;
            }else{
                length = 0;
            }

            maxLength = Math.max(maxLength,length);
        }
        return maxLength;
    }
}