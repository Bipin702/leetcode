class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        
        for(int i = n-1; i > 0; i--){
            if(nums[i-1] != nums[i]){
                count += n-i;
            }
        }
        return count;
    }
}