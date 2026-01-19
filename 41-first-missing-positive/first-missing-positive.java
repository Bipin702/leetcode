class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int i = 0;
        while(i < n){
            int correctIndex = nums[i]-1;

            if(nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else{
                i++;
            }
        }

        for(int index = 0; index < n; index++){
            if(nums[index] != index+1){
                return index+1;
            }
        }
        return nums.length+1;
    }

    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}