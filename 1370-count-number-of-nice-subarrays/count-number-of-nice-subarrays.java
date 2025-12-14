class Solution {
    public int numberOfSubarrays(int[] nums, int goal) {
     return CountAtMost(nums,goal) - CountAtMost(nums,goal-1);
    }

    public int CountAtMost(int[] nums, int goal){
        if(goal < 0) return 0;
        int n = nums.length;
        int sum = 0;
        int count = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            sum += (nums[right] %2);

            while(sum > goal){
                sum -= (nums[left]%2);
                left++;
            }
            count += (right-left+1);
        }
        return count;
    }
}