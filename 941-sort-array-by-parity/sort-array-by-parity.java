class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;

        int left = 0;

        for(int i = 0; i < n; i++){
            if(nums[i] % 2 == 0){
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
        return nums;
    }
}