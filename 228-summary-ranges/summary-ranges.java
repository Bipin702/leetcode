class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        int i = 0;
        for(int j = 0; j < n; j++){
            i = nums[j];
            while(j+1 < n && nums[j+1] - nums[j] == 1){
                j++;
            }

            if(i != nums[j]){
                ans.add(i + "->" + nums[j]);
            }else{
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }
}