class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        
        int i = 0;

        while(i < n){
            int correctIndex = nums[i] - 1;

            if(nums[i] != nums[correctIndex]){
                swap(nums, i, correctIndex);
            }else{
                i++;
            }
        }

        for(int index = 0; index < n; index++){
            if(nums[index] != index+1){
                return new int[]{nums[index],index+1};
            }
        }
        return new int[]{-1,-1};
    }

    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}