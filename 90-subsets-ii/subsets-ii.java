class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        Arrays.sort(nums);
        solve(0,nums,sub,ans);
        return ans;
    }    

    public void solve(int index, int[] nums, List<Integer> sub, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[index]);
        solve(index+1,nums,sub,ans);
        sub.remove(sub.size()-1);

        while(index+1 < nums.length && nums[index] == nums[index+1]) index++;

        solve(index+1, nums, sub, ans);
    }
}