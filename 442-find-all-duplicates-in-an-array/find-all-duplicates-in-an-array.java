class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        int i = 0;

        while(i < n){
            int correctIndex = nums[i] - 1;
            if(nums[i] != nums[correctIndex]){
                swap(nums,i,correctIndex);
            }else{
            i++;
            }
        }

        for(int index = 0; index < n; index++){
            if(nums[index] != index+1) ans.add(nums[index]);
        }
        return ans;
    }

    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}