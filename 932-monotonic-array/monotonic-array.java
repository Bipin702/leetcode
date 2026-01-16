class Solution {
    public boolean isMonotonic(int[] nums) {

        boolean increasing= false;
        boolean decreasing = false;
        for(int i = 0;i < nums.length-1; i++){
            if(nums[i] < nums[i+1]){
                increasing = true;
            }

            if(nums[i] > nums[i+1]){
                decreasing = true;
            }
        }
        return !(increasing && decreasing);
    }
}