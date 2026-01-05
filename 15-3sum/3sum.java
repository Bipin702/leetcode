class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if(n < 3) return ans;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int n1 = nums[i];
            int target = -n1;

            TwoSum(i+1,n-1,nums,target);
        }
        return ans;
    }

    public void TwoSum(int i, int j, int[] nums, int target){
        int n = nums.length;

        while(i < j){
            if(nums[i] + nums[j] > target){
                j--;
            }else if(nums[i] + nums[j] < target){
                i++;
            }else{
                while(i < j && nums[i] == nums[i+1]) i++;
                while(i < j && nums[j] == nums[j-1]) j--;

                ans.add(Arrays.asList(-target,nums[i],nums[j]));

                i++;
                j--;
            }
        }
    }
}