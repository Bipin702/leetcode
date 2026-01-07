class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int k = n-1;

        while(j <= k){
            if(nums[j] == 2){
                swap(j,k,nums);
                k--;
            }else if(nums[j] == 1){
                j++;
            }else{
                swap(i,j,nums);
                i++;
                j++;
            }
        }
    }

    public void swap(int first, int second, int[] nums){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}