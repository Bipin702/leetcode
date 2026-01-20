class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long count = 1;
        long curr = 1;
        for(int i = 1; i < n; i++){
            if(nums[i] != nums[i-1]){
                curr ++;
            }else{
                curr = 1;
            }
            count += curr;
        }
        return count;
    }
}